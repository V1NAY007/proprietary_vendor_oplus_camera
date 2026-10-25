package com.color.app;

public class ColorAccessControlManager {
    public static final int USER_CURRENT = 0;
    private static final ColorAccessControlManager sInstance = new ColorAccessControlManager();

    public static ColorAccessControlManager getInstance() {
        return sInstance;
    }

    public boolean isEncryptedPackage(String packageName, int userId) {
        return false;
    }

    public boolean isEncryptPass(String packageName, int userId) {
        return false;
    }
}
