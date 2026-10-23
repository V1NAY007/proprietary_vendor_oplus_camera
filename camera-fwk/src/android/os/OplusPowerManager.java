package android.os;

public class OplusPowerManager {
    public static final int BRIGHTNESS_MULTIBITS_NONE = 0;
    public static final int BRIGHTNESS_MULTIBITS_ONE = 1;
    public static final int BRIGHTNESS_MULTIBITS_TWO = 2;

    private static OplusPowerManager sInstance = null;

    public OplusPowerManager() {}

    public static synchronized OplusPowerManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusPowerManager();
        }
        return sInstance;
    }

    public int getMaximumScreenBrightnessSetting() {
        return 255;
    }

    public int getMinimumScreenBrightnessSetting() {
        return 0;
    }
}
