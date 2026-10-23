package android.view;

public class OplusWindowManager {
    private static OplusWindowManager sInstance = null;

    public OplusWindowManager() {}

    public static synchronized OplusWindowManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusWindowManager();
        }
        return sInstance;
    }

    public void requestKeyguard(String command) {}

    public boolean setPreferredDisplayMode(int mode) {
        return false;
    }
}
