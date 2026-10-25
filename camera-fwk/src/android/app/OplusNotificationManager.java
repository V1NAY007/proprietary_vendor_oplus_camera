package android.app;

public class OplusNotificationManager {
    public OplusNotificationManager() {}

    public String[] getEnableNavigationApps(int type) {
        return new String[0];
    }

    public boolean isDriveNavigationMode(String pkg, int type) {
        return false;
    }

    public boolean isSuppressedByDriveMode(int type) {
        return false;
    }

    public void setSuppressedByDriveMode(boolean suppress, int type) {}
}
