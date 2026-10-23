package com.oplus.osense;

import android.content.Context;
import android.os.Bundle;
import com.oplus.osense.eventinfo.EventConfig;
import com.oplus.osense.eventinfo.OsenseEventCallback;
import com.oplus.osense.task.BgRunningCallback;

public class OsenseResEventClient {
    private static OsenseResEventClient sInstance = null;

    public OsenseResEventClient() {}

    public static synchronized OsenseResEventClient getInstance() {
        if (sInstance == null) {
            sInstance = new OsenseResEventClient();
        }
        return sInstance;
    }

    public int registerEventCallback(OsenseEventCallback callback, EventConfig config) {
        return 0;
    }

    public int unregisterEventCallback(OsenseEventCallback callback) {
        return 0;
    }

    public int unregisterEventCallbackWithConfig(OsenseEventCallback callback, EventConfig config) {
        return 0;
    }

    public void requestSceneAction(Bundle bundle) {}

    public void startBackgroundRunning(Context context, int reason, BgRunningCallback callback) {}

    public boolean stopBackgroundRunning(Context context, int reason) {
        return false;
    }

    public int requestInstantCpuLoad() {
        return 0;
    }
}
