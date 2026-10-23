package com.oplus.wrapper.os;

public class PowerManager {
    private final android.os.PowerManager mPowerManager;

    public PowerManager(android.os.PowerManager powerManager) {
        mPowerManager = powerManager;
    }

    public int getMaximumScreenBrightnessSetting() {
        if (mPowerManager != null) {
            return mPowerManager.getMaximumScreenBrightnessSetting();
        }
        return 255;
    }

    public int getMinimumScreenBrightnessSetting() {
        if (mPowerManager != null) {
            return mPowerManager.getMinimumScreenBrightnessSetting();
        }
        return 0;
    }
}
