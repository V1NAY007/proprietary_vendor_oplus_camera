package com.oplus.osense;

import android.os.Bundle;

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

    public long[][][] osenseGetPerfLimit() {
        return new long[0][0][0];
    }
}
