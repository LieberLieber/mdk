package org.openmbee.mdk;

import com.nomagic.magicdraw.cookies.CloseCookie;
import com.nomagic.magicdraw.cookies.CookieSet;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.plugins.Plugin;
import org.openmbee.mdk.mms.sync.coordinated.CoordinatedSyncProjectEventListenerAdapter;
import org.openmbee.mdk.mms.sync.delta.DeltaSyncProjectEventListenerAdapter;
import org.openmbee.mdk.mms.sync.local.LocalDeltaProjectEventListenerAdapter;
import org.openmbee.mdk.mms.sync.mms.MMSDeltaProjectEventListenerAdapter;
import org.openmbee.mdk.mms.sync.status.SyncStatusProjectEventListenerAdapter;
import org.openmbee.mdk.util.TaskRunner;

/*
 * This class is responsible for performing automatic syncs with
 * MMS whenever any type of commit is executed.
 * This class is also responsible for start the REST web services.
 */
public class MMSSyncPlugin extends Plugin {
    private static MMSSyncPlugin instance;
    private LocalDeltaProjectEventListenerAdapter localDeltaProjectEventListenerAdapter;
    private MMSDeltaProjectEventListenerAdapter mmsDeltaProjectEventListenerAdapter;
    private DeltaSyncProjectEventListenerAdapter deltaSyncProjectEventListenerAdapter;
    private CoordinatedSyncProjectEventListenerAdapter coordinatedSyncProjectEventListenerAdapter;
    private SyncStatusProjectEventListenerAdapter syncStatusProjectEventListenerAdapter;

    public static MMSSyncPlugin getInstance() {
        if (instance == null) {
            instance = new MMSSyncPlugin();
        }
        return instance;
    }

    public LocalDeltaProjectEventListenerAdapter getLocalDeltaProjectEventListenerAdapter() {
        return localDeltaProjectEventListenerAdapter;
    }

    public MMSDeltaProjectEventListenerAdapter getMmsDeltaProjectEventListenerAdapter() {
        return mmsDeltaProjectEventListenerAdapter;
    }

    public DeltaSyncProjectEventListenerAdapter getDeltaSyncProjectEventListenerAdapter() {
        return deltaSyncProjectEventListenerAdapter;
    }

    public CoordinatedSyncProjectEventListenerAdapter getCoordinatedSyncProjectEventListenerAdapter() {
        return coordinatedSyncProjectEventListenerAdapter;
    }

    public SyncStatusProjectEventListenerAdapter getSyncStatusProjectEventListenerAdapter() {
        return syncStatusProjectEventListenerAdapter;
    }

    @Override
    public void init() {
        // Order matters!
        Application.getInstance().getProjectsManager().addProjectListener(coordinatedSyncProjectEventListenerAdapter = new CoordinatedSyncProjectEventListenerAdapter());
        Application.getInstance().getProjectsManager().addProjectListener(deltaSyncProjectEventListenerAdapter = new DeltaSyncProjectEventListenerAdapter());
        // Common and MMS clear their respective inMemoryChangelogs on save, so it needs to go after coordinated and delta which use it.
        Application.getInstance().getProjectsManager().addProjectListener(localDeltaProjectEventListenerAdapter = new LocalDeltaProjectEventListenerAdapter());
        Application.getInstance().getProjectsManager().addProjectListener(mmsDeltaProjectEventListenerAdapter = new MMSDeltaProjectEventListenerAdapter());
        Application.getInstance().getProjectsManager().addProjectListener(syncStatusProjectEventListenerAdapter = new SyncStatusProjectEventListenerAdapter());

        Application.getInstance().addSaveParticipant(coordinatedSyncProjectEventListenerAdapter);

        CookieSet cookieSet = Application.getInstance().getCookieSet();
        CloseCookie closeCookie = (CloseCookie) cookieSet.getCookie(CloseCookie.class);
        if (closeCookie != null) {
            cookieSet.remove(closeCookie);
        }
        cookieSet.add(new TaskRunner.TaskRunnerCloseCookie(closeCookie));
    }

    @Override
    public boolean close() {
        return true;
    }

    public boolean isSupported() {
        return true;
    }
}
