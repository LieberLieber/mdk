package org.openmbee.mdk.options;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.options.AbstractPropertyOptionsGroup;
import com.nomagic.magicdraw.properties.*;
import com.nomagic.magicdraw.ui.ImageMap16;
import org.openmbee.mdk.util.MDUtils;

import javax.swing.*;
import java.io.File;

public class MDKOptionsGroup extends AbstractPropertyOptionsGroup {

    public static final String ID = "options.mdk";
    public static final String GROUP = "GROUP";
    private static MDKOptionsGroup tempInstance = null;

    public static final String LOG_JSON_ID = "LOG_JSON_ID",
            PERSIST_CHANGELOG_ID = "PERSIST_CHANGELOG_ID",
            ENABLE_CHANGE_LISTENER_ID = "ENABLE_CHANGE_LISTENER_ID",
            ENABLE_COORDINATED_SYNC_ID = "ENABLE_COORDINATED_SYNC_ID",
            CUSTOM_USER_SCRIPT_DIRECTORIES_ID = "CUSTOM_USER_SCRIPT_DIRECTORIES_ID",
    		DOCBOOK_TO_PDF_STYLESHEET = "DOCBOOK_TO_PDF_STYLESHEET",
    		EXPORT_MDKZIP_DIAGRAM_ELEMENTS_MAPPING = "EXPORT_MDKZIP_DIAGRAM_ELEMENTS_MAPPING";

    public MDKOptionsGroup() {
        super(ID);
    }

    public static MDKOptionsGroup getMDKOptions() {
        MDKOptionsGroup group = (MDKOptionsGroup) Application.getInstance().getEnvironmentOptions().getGroup(ID);
        if (group == null) {
            if (tempInstance == null) {
                tempInstance = new MDKOptionsGroup();
            }
            return tempInstance;
        }
        return group;
    }

    public boolean isLogJson() {
        if (MDUtils.isDeveloperMode()) {
            return true;
        }
        Property p = getProperty(LOG_JSON_ID);
        return (Boolean) p.getValue();
    }

    public void setLogJson(boolean value) {
        BooleanProperty property = new BooleanProperty(LOG_JSON_ID, value);
        property.setResourceProvider(PROPERTY_RESOURCE_PROVIDER);
        property.setGroup(GROUP);
        addProperty(property, true);
    }

    public boolean isPersistChangelog() {
        Property p = getProperty(PERSIST_CHANGELOG_ID);
        return (Boolean) p.getValue();
    }

    public void setPersistChangelog(boolean value) {
        BooleanProperty property = new BooleanProperty(PERSIST_CHANGELOG_ID, value);
        property.setResourceProvider(PROPERTY_RESOURCE_PROVIDER);
        property.setGroup(GROUP);
        if (MDUtils.isDeveloperMode()) {
            addProperty(property, true);
        }
        else {
            addInvisibleProperty(property);
        }
    }

    public boolean isChangeListenerEnabled() {
        Property p = getProperty(ENABLE_CHANGE_LISTENER_ID);
        return (Boolean) p.getValue();
    }

    public void setChangeListenerEnabled(boolean value) {
        BooleanProperty property = new BooleanProperty(ENABLE_CHANGE_LISTENER_ID, value);
        property.setResourceProvider(PROPERTY_RESOURCE_PROVIDER);
        property.setGroup(GROUP);
        if (MDUtils.isDeveloperMode()) {
            addProperty(property, true);
        }
        else {
            addInvisibleProperty(property);
        }
    }

    public boolean isCoordinatedSyncEnabled() {
        Property p = getProperty(ENABLE_COORDINATED_SYNC_ID);
        return (Boolean) p.getValue();
    }

    public void setCoordinatedSyncEnabled(boolean value) {
        BooleanProperty property = new BooleanProperty(ENABLE_COORDINATED_SYNC_ID, value);
        property.setResourceProvider(PROPERTY_RESOURCE_PROVIDER);
        property.setGroup(GROUP);
        if (MDUtils.isDeveloperMode()) {
            addProperty(property, true);
        }
        else {
            addInvisibleProperty(property);
        }
    }

    public File[] getCustomUserScriptDirectories() {
        Property p = getProperty(CUSTOM_USER_SCRIPT_DIRECTORIES_ID);
        String val = p.getValueStringRepresentation();
        if (val == null || val.isEmpty()) {
            return null;
        }
        File[] dirs = new File[getNumberOfCustomUserScriptDirectories()];
        for (int i = 0; i < getNumberOfCustomUserScriptDirectories(); i++) {
            dirs[i] = new File(val.split(File.pathSeparator)[i]);
        }
        return dirs;
    }

    public int getNumberOfCustomUserScriptDirectories() {
        Property p = getProperty(CUSTOM_USER_SCRIPT_DIRECTORIES_ID);
        String val = p.getValueStringRepresentation();
        if (val == null || val.isEmpty()) {
            return 0;
        }
        return val.split(File.pathSeparator).length;

    }

    public void setUserScriptDirectory(String path) {
        StringProperty property = new StringProperty(CUSTOM_USER_SCRIPT_DIRECTORIES_ID, path);
        property.setResourceProvider(PROPERTY_RESOURCE_PROVIDER);
        property.setGroup(GROUP);
        addProperty(property, true);
    }
    
    
    public String getDocBookToPDFStyleSheet() {
    	Property p = getProperty(DOCBOOK_TO_PDF_STYLESHEET);
		return (String) p.getValue();
    }
    
    public void setDocBookToPDFStyleSheet(String value) {
    	FileProperty property = new FileProperty(DOCBOOK_TO_PDF_STYLESHEET, value, FileProperty.FILES_ONLY);
    	property.setResourceProvider(PROPERTY_RESOURCE_PROVIDER);
    	property.setGroup(GROUP);
    	addProperty(property, true);
    }

    public void setExportMdkzipDiagramElementsMapping(Boolean value) {
        BooleanProperty property = new BooleanProperty(EXPORT_MDKZIP_DIAGRAM_ELEMENTS_MAPPING, value);
        property.setResourceProvider(PROPERTY_RESOURCE_PROVIDER);
        property.setGroup(GROUP);
        addProperty(property, true);    	
    }
    
    public boolean isExportMdkzipDiagramElementsMappingEnabled() {
        Property p = getProperty(EXPORT_MDKZIP_DIAGRAM_ELEMENTS_MAPPING);
        return (Boolean) p.getValue();
    }

    public static final PropertyResourceProvider PROPERTY_RESOURCE_PROVIDER = (key, property) -> EnvironmentOptionsResources.getString(key);

    @Override
    public void setDefaultValues() {
        setLogJson(false);
        setPersistChangelog(true);
        setChangeListenerEnabled(true);
        setCoordinatedSyncEnabled(true);
        setUserScriptDirectory("");
        setDocBookToPDFStyleSheet("");
        setExportMdkzipDiagramElementsMapping(true);
    }

    private static final String MDK_OPTIONS_NAME = "MDK_OPTIONS_NAME";

    @Override
    public String getName() {
        return EnvironmentOptionsResources.getString(MDK_OPTIONS_NAME);
    }

    @Override
    public Icon getGroupIcon() {
        return ImageMap16.SETTINGS;
    }
}
