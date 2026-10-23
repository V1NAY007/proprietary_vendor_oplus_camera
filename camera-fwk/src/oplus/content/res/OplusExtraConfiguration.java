package oplus.content.res;

import android.content.res.Configuration;

public class OplusExtraConfiguration {
    public int mFontVariationSettings;
    public long mMaterialColor;
    public int mUserId;
    public long mThemeChangedFlags;
    public OplusExtraConfiguration mOplusExtraConfiguration = this;

    public static OplusExtraConfiguration c(Configuration config) {
        return new OplusExtraConfiguration();
    }
}
