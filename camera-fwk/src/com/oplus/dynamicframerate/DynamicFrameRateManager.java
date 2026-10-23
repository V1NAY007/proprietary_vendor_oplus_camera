package com.oplus.dynamicframerate;

import android.os.Bundle;
import android.view.SurfaceControl;

public class DynamicFrameRateManager {
    public static boolean setFrameRate(Object view, int frameRate, int preferredFrameRate, Bundle bundle) {
        return false;
    }

    public static boolean setFrameRateNoContext(Object view, SurfaceControl.Transaction transaction, int frameRate, int preferredFrameRate, Bundle bundle) {
        return false;
    }

    public static int getDynamicFrameRateType() {
        return 0;
    }

    public static int getSuggestFrameRate(float velocity, int type) {
        return 0;
    }

    public static boolean isTypeEnable(int type) {
        return false;
    }
}
