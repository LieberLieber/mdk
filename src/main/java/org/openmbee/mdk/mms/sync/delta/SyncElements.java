package org.openmbee.mdk.mms.sync.delta;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nomagic.magicdraw.commands.Command;
import com.nomagic.magicdraw.commands.CommandHistory;
import com.nomagic.magicdraw.commands.MacroCommand;
import com.nomagic.magicdraw.commands.RemoveCommandCreator;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.InstanceSpecification;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.LiteralString;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import org.openmbee.mdk.api.incubating.MDKConstants;
import org.openmbee.mdk.api.incubating.convert.Converters;
import org.openmbee.mdk.json.JacksonUtils;
import org.openmbee.mdk.util.Changelog;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by igomes on 7/25/16.
 */

public class SyncElements {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH.mm.ss.SSSZ");

    private static String getSyncPackageID(Project project) {
        return Converters.getIProjectToIdConverter().apply(project.getPrimaryProject()) + MDKConstants.SYNC_SYSML_ID_SUFFIX;
    }

    public static Package getSyncPackage(Project project) {
        String folderId = getSyncPackageID(project);
        Element folder = Converters.getIdToElementConverter().apply(folderId, project);
        return folder instanceof Package ? (Package) folder : null;
    }

    public static Collection<SyncElement> getAllByType(Project project, SyncElement.Type type) {
        Package syncPackage = getSyncPackage(project);
        if (syncPackage == null) {
            return Collections.emptyList();
        }
        return syncPackage.getPackagedElement().stream().filter(element -> element.getName().matches(type.getPrefix() + "_\\d.*")).map(element -> new SyncElement(element, type)).collect(Collectors.toList());
    }

    public static SyncElement setByType(Project project, SyncElement.Type type, String comment) {
        getAllByType(project, type).stream().map(SyncElement::getElement).forEach(element -> {
            try {
                Command command = RemoveCommandCreator.getCommand(element);
                command.execute();
                MacroCommand macroCommand = CommandHistory.getCommandForAppend(element);
                macroCommand.add(command);
            } catch (RuntimeException e) {
                System.out.println("Unable to delete sync element: " + element.getName());
                e.printStackTrace();
            }
        });

        project.getCounter().setCanResetIDForObject(true);
        Package syncPackage = getSyncPackage(project);
        if (syncPackage == null) {
            syncPackage = project.getElementsFactory().createPackageInstance();
            syncPackage.setOwner(project.getModel());
            syncPackage.setName("__MMSSync__");
            syncPackage.setID(getSyncPackageID(project));
        }

        LiteralString literalString = project.getElementsFactory().createLiteralStringInstance();
        literalString.setLocalID(literalString.getLocalID() + MDKConstants.SYNC_SYSML_ID_SUFFIX);
        literalString.setValue(comment);

        InstanceSpecification instanceSpecification = project.getElementsFactory().createInstanceSpecificationInstance();
        instanceSpecification.setLocalID(instanceSpecification.getLocalID() + MDKConstants.SYNC_SYSML_ID_SUFFIX);
        instanceSpecification.setOwningPackage(syncPackage);
        instanceSpecification.setName(type.toString().toLowerCase() + "_" + ZonedDateTime.now().format(DATE_TIME_FORMATTER));
        instanceSpecification.setSpecification(literalString);

        return new SyncElement(instanceSpecification, type);
    }

    @SuppressWarnings("unchecked")
    public static ObjectNode buildJson(Changelog<String, ?> changelog) {
        ObjectNode objectNode = JacksonUtils.getObjectMapper().createObjectNode();
        for (Changelog.ChangeType changeType : Changelog.ChangeType.values()) {
            ArrayNode arrayNode = JacksonUtils.getObjectMapper().createArrayNode();
            changelog.get(changeType).keySet().forEach(arrayNode::add);
            objectNode.set(changeType.name().toLowerCase(), arrayNode);
        }
        return objectNode;
    }

    public static Changelog<String, Void> buildChangelog(SyncElement syncElement) {
        Changelog<String, Void> changelog = new Changelog<>();
        return buildChangelog(changelog, syncElement);
    }

    public static String getValue(SyncElement syncElement) {
        InstanceSpecification syncInstance;
        String body;
        if (syncElement == null || syncElement.getElement() == null) {
            return null;
        }
        else if (syncElement.getElement() instanceof InstanceSpecification && (syncInstance = (InstanceSpecification) syncElement.getElement()).getSpecification() instanceof LiteralString) {
            body = ((LiteralString) syncInstance.getSpecification()).getValue();
        }
        else {
            body = ModelHelper.getComment(syncElement.getElement());
        }
        return body;
    }

    public static Changelog<String, Void> buildChangelog(Changelog changelog, SyncElement syncElement) {
        if (syncElement == null || syncElement.getElement() == null) {
            return new Changelog<>();
        }
        String body = getValue(syncElement);
        if (body != null) {
            try {
                JsonNode jsonNode = JacksonUtils.getObjectMapper().readTree(body);
                if (jsonNode != null && jsonNode.isObject()) {
                    return buildChangelog(changelog, (ObjectNode) jsonNode);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Changelog<>();
    }

    public static Changelog<String, Void> buildChangelog(ObjectNode objectNode) {
        Changelog<String, Void> changelog = new Changelog<>();
        return buildChangelog(changelog, objectNode);
    }

    public static Changelog<String, Void> buildChangelog(Changelog changelog, ObjectNode objectNode) {
        for (Changelog.ChangeType changeType : Changelog.ChangeType.values()) {
            JsonNode jsonNode = objectNode.get(changeType.name().toLowerCase());
            if (jsonNode == null || !jsonNode.isArray()) {
                continue;
            }
            for (JsonNode jsonNode1 : jsonNode) {
                if (jsonNode1 == null || !jsonNode1.isTextual()) {
                    continue;
                }
                changelog.addChange(jsonNode1.asText(), (Void) null, changeType);
            }
        }
        return changelog;
    }
}
