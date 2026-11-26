package com.oplus.osense;

import android.os.Bundle;
import com.oplus.osense.info.OsenseSaRequest;

public class OsenseResClient {
    private static OsenseResClient sInstance = null;

    public OsenseResClient() {}

    public OsenseResClient(Class<?> clazz) {}

    public static synchronized OsenseResClient get(Class<?> clazz) {
        if (sInstance == null) {
            sInstance = new OsenseResClient(clazz);
        }
        return sInstance;
    }

    public void releaseSysResource(int type) {}
    public void requestSysResource(int type, Bundle bundle) {}
    public void reportKeyThread(String str, int pid, int tid, Bundle bundle) {}
    public void removeKeyThread(int type, Bundle bundle) {}
    public void removeKeyThread(String str, Bundle bundle) {}

    // No stock Osense service; use the same no-boost fallback as the ORMS shim.
    public long osenseSetSceneAction(OsenseSaRequest request) {
        return 0L;
    }

    public void osenseClrSceneAction(long actionId) {}

    public long[][][] osenseGetPerfLimit() {
        return new long[0][0][0];
    }
}
