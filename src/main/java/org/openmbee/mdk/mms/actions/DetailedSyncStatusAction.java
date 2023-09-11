package org.openmbee.mdk.mms.actions;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import org.openmbee.mdk.actions.LockAction;
import org.openmbee.mdk.api.incubating.convert.Converters;
import org.openmbee.mdk.mms.sync.delta.SyncElement;
import org.openmbee.mdk.mms.sync.delta.SyncElements;
import org.openmbee.mdk.mms.sync.local.LocalDeltaProjectEventListenerAdapter;
import org.openmbee.mdk.mms.sync.local.LocalDeltaTransactionCommitListener;
import org.openmbee.mdk.mms.sync.mms.MMSDeltaProjectEventListenerAdapter;
import org.openmbee.mdk.util.Changelog;
import org.openmbee.mdk.util.Utils;
import org.openmbee.mdk.validation.ValidationRule;
import org.openmbee.mdk.validation.ValidationRuleViolation;
import org.openmbee.mdk.validation.ValidationSuite;
import org.openmbee.mdk.validation.ViolationSeverity;

import javax.annotation.CheckForNull;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by igomes on 12/5/16.
 */
public class DetailedSyncStatusAction extends MDAction {
    public DetailedSyncStatusAction() {
        super(DetailedSyncStatusAction.class.getSimpleName(), DetailedSyncStatusAction.class.getSimpleName(), null, null);
    }

    private static final ValidationSuite validationSuite = new ValidationSuite("Sync Status");

    private static final ValidationRule
            locallyCreatedValidationRule = new ValidationRule("Locally Created", "The model shall not have any locally created elements that are unsynced.", ViolationSeverity.INFO),
            locallyUpdatedValidationRule = new ValidationRule("Locally Updated", "The model shall not have any locally updated elements that are unsynced.", ViolationSeverity.INFO),
            locallyDeletedValidationRule = new ValidationRule("Locally Deleted", "The model shall not have any locally deleted elements that are unsynced.", ViolationSeverity.INFO),
            mmsCreatedValidationRule = new ValidationRule("MMS Created", "The model shall not have any MMS created elements that are unsynced.", ViolationSeverity.INFO),
            mmsUpdatedValidationRule = new ValidationRule("MMS Updated", "The model shall not have any MMS updated elements that are unsynced.", ViolationSeverity.INFO),
            mmsDeletedValidationRule = new ValidationRule("MMS Deleted", "The model shall not have any MMS deleted elements that are unsynced.", ViolationSeverity.INFO);

    private static final Map<SyncElement.Type, Map<Changelog.ChangeType, ValidationRule>> validationRuleMap = new HashMap<>(SyncElement.Type.values().length);

    static {
        validationSuite.addValidationRule(locallyCreatedValidationRule);
        validationSuite.addValidationRule(locallyUpdatedValidationRule);
        validationSuite.addValidationRule(locallyDeletedValidationRule);
        validationSuite.addValidationRule(mmsCreatedValidationRule);
        validationSuite.addValidationRule(mmsUpdatedValidationRule);
        validationSuite.addValidationRule(mmsDeletedValidationRule);

        Map<Changelog.ChangeType, ValidationRule> localValidationRuleMap = new HashMap<>(SyncElement.Type.values().length);
        localValidationRuleMap.put(Changelog.ChangeType.CREATED, locallyCreatedValidationRule);
        localValidationRuleMap.put(Changelog.ChangeType.UPDATED, locallyUpdatedValidationRule);
        localValidationRuleMap.put(Changelog.ChangeType.DELETED, locallyDeletedValidationRule);
        validationRuleMap.put(SyncElement.Type.LOCAL, localValidationRuleMap);

        Map<Changelog.ChangeType, ValidationRule> mmsValidationRuleMap = new HashMap<>(SyncElement.Type.values().length);
        mmsValidationRuleMap.put(Changelog.ChangeType.CREATED, mmsCreatedValidationRule);
        mmsValidationRuleMap.put(Changelog.ChangeType.UPDATED, mmsUpdatedValidationRule);
        mmsValidationRuleMap.put(Changelog.ChangeType.DELETED, mmsDeletedValidationRule);
        validationRuleMap.put(SyncElement.Type.MMS, mmsValidationRuleMap);
    }

    @Override
    public void actionPerformed(@CheckForNull ActionEvent actionEvent) {
        super.actionPerformed(actionEvent);

        for (ValidationRule validationRule : validationSuite.getValidationRules()) {
            validationRule.getViolations().clear();
        }
        Project project = Application.getInstance().getProject();
        if (project == null) {
            return;
        }
        for (SyncElement.Type syncElementType : SyncElement.Type.values()) {
            Collection<SyncElement> syncElements = SyncElements.getAllByType(project, syncElementType);
            for (SyncElement syncElement : syncElements) {
                Changelog<String, Void> changelog = SyncElements.buildChangelog(syncElement);
                for (Changelog.ChangeType changeType : Changelog.ChangeType.values()) {
                    for (String key : changelog.get(changeType).keySet()) {
                        String comment = "Source: [" + syncElementType.name() + "] | Type: [" + changeType.name() + "]";
                        Element element = Converters.getIdToElementConverter().apply(key, project);
                        validationRuleMap.get(syncElementType).get(changeType).addViolation(new ValidationRuleViolation(element, comment));
                    }
                }
            }
        }
        for (Changelog.ChangeType changeType : Changelog.ChangeType.values()) {
            LocalDeltaTransactionCommitListener localDeltaTransactionCommitListener = LocalDeltaProjectEventListenerAdapter.getProjectMapping(project).getLocalDeltaTransactionCommitListener();
            if (localDeltaTransactionCommitListener != null) {
                ValidationRule validationRule = validationRuleMap.get(SyncElement.Type.LOCAL).get(changeType);
                for (Map.Entry<String, Element> entry : localDeltaTransactionCommitListener.getInMemoryLocalChangelog().get(changeType).entrySet()) {
                    Element element = entry.getValue();
                    validationRule.addViolation(element, "Source: [" + SyncElement.Type.LOCAL.name() + "] | Type: [" + changeType.name() + "]" + (element != null && !project.isDisposed(element) ? "" : " | " + entry.getKey()));
                }
            }
            ValidationRule validationRule = validationRuleMap.get(SyncElement.Type.MMS).get(changeType);
            for (Map.Entry<String, Void> entry : MMSDeltaProjectEventListenerAdapter.getProjectMapping(project).getInMemoryChangelog().get(changeType).entrySet()) {
                Element element = Converters.getIdToElementConverter().apply(entry.getKey(), project);
                validationRule.addViolation(new ValidationRuleViolation(element, "Source: [" + SyncElement.Type.MMS.name() + "] | Type: [" + changeType.name() + "]"));
            }
        }

        if (project.isRemote()) {
            for (ValidationRule validationRule : validationSuite.getValidationRules()) {
                for (ValidationRuleViolation validationRuleViolation : validationRule.getViolations()) {
                    validationRuleViolation.addAction(new LockAction(validationRuleViolation.getElement(), false));
                    validationRuleViolation.addAction(new LockAction(validationRuleViolation.getElement(), true));
                }
            }
        }

        if (validationSuite.hasErrors()) {
            Utils.displayValidationWindow(project, validationSuite, validationSuite.getName());
        }
        else {
            Application.getInstance().getGUILog().log("[INFO] No unsynced elements detected.");
        }
    }
}
