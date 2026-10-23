package com.oplus.app;

public class OPlusAccessControlManager {
    public static final int USER_CURRENT = 0;
    private static OPlusAccessControlManager sInstance = null;

    public static synchronized OPlusAccessControlManager getInstance() {
        if (sInstance == null) {
            sInstance = new OPlusAccessControlManager();
        }
        return sInstance;
    }

    public boolean isEncryptedPackage(String packageName, int userId) {
        return false;
    }

    public boolean isEncryptPass(String packageName, int userId) {
        return false;
    }
}
