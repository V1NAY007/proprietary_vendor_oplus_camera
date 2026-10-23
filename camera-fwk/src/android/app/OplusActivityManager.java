package android.app;

import android.content.ComponentName;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public class OplusActivityManager {
    private static OplusActivityManager sInstance = null;

    public OplusActivityManager() {}

    public static synchronized OplusActivityManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusActivityManager();
        }
        return sInstance;
    }

    public List<String> getAllTopPkgName() {
        return new ArrayList<>();
    }

    public List<ActivityManager.RunningAppProcessInfo> getAllTopAppInfos() {
        return new ArrayList<>();
    }

    public ComponentName getTopActivityComponentName() {
        return null;
    }

    public boolean requestDeviceFolded(int displayId, boolean folded) {
        return false;
    }

    public void startActivity(Intent intent) {}
}
