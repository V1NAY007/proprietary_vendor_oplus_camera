package android.common;

import android.content.Context;

public class ColorFrameworkFactory {
    private static final ColorFrameworkFactory sInstance = new ColorFrameworkFactory();

    public static ColorFrameworkFactory getInstance() {
        return sInstance;
    }

    public Object getColorDeepThinkerManager(Context context) {
        return null;
    }
}
