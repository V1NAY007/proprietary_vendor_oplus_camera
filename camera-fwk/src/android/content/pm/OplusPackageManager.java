package android.content.pm;

import android.content.Context;

public class OplusPackageManager {
    private static OplusPackageManager sInstance = null;

    public OplusPackageManager() {}

    public OplusPackageManager(Context context) {}

    public static synchronized OplusPackageManager getOplusPackageManager(Context context) {
        if (sInstance == null) {
            sInstance = new OplusPackageManager(context);
        }
        return sInstance;
    }

    public static synchronized OplusPackageManager getOplusPackageManager() {
        if (sInstance == null) {
            sInstance = new OplusPackageManager();
        }
        return sInstance;
    }

    public void fixupAppData(String packageName, String path, int flags) {}

    public int getOplusFreezePackageState(String pkg, int userId) {
        return 0;
    }

    public boolean isClosedSuperFirewall() {
        return false;
    }

    public int oplusUnFreezePackage(String pkg, int state, int flags, int userId, String reason) {
        return 0;
    }
}
