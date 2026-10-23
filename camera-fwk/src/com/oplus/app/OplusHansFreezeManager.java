package com.oplus.app;

import android.content.Context;

public class OplusHansFreezeManager {
    private static OplusHansFreezeManager sInstance = null;

    public static synchronized OplusHansFreezeManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusHansFreezeManager();
        }
        return sInstance;
    }

    public void registerHansListener(String pkg, Object callback) {}
    public void unregisterHansListener(String pkg, Object callback) {}

    public int requestFastFreeze(Context context, int reason, String pkg) {
        return 0;
    }
}
