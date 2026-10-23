package android.hardware.display;

public class OplusosDisplayManager {
    public static final int BRIGHTNESS_MULTIBITS_NONE = 0;
    public static final int BRIGHTNESS_MULTIBITS_ONE = 1;
    public static final int BRIGHTNESS_MULTIBITS_TWO = 2;

    private static OplusosDisplayManager sInstance = null;

    public OplusosDisplayManager() {}

    public static synchronized OplusosDisplayManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusosDisplayManager();
        }
        return sInstance;
    }

    public void setScreenBrightness(int brightness) {}
    public int getScreenBrightness() { return 100; }
    public void setTemporaryAutoBrightnessAdjustment(float adjustment) {}
}
