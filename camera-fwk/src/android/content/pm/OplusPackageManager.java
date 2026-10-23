package android.content.pm;

import android.content.Context;

public class OplusPackageManager {
    private static OplusPackageManager sInstance = null;

    public static synchronized OplusPackageManager getOplusPackageManager(Context context) {
        if (sInstance == null) {
            sInstance = new OplusPackageManager();
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
}
