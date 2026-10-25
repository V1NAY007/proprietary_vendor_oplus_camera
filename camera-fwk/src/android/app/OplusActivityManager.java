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

    public void addBackgroundRestrictedInfo(String pkg, List<String> list) {}

    public void addPreventIndulgeList(List<String> list) {}

    public List<ActivityManager.RunningTaskInfo> getFilteredTasks(int maxNum, boolean filterOnlyVisibleRecents) {
        return new ArrayList<>();
    }

    public List<ActivityManager.RunningTaskInfo> getFilteredTasks(int maxNum, int filterOnlyVisibleRecents, int flags) {
        return new ArrayList<>();
    }

    public List<String> getTaskPkgList(int taskId) {
        return new ArrayList<>();
    }

    public void handleAppFromControlCenter(String pkg, int type) {}

    public boolean isAppCallRefuseMode() {
        return false;
    }

    public void setAllowLaunchApps(List<String> list) {}

    public void setAppCallRefuseMode(boolean enable) {}

    public void setChildSpaceMode(boolean enable) {}

    public void setPreventIndulgeController(Object controller) {}
}
