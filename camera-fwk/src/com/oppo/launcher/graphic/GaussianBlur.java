package com.oppo.launcher.graphic;

import android.content.Context;
import android.graphics.Bitmap;

public class GaussianBlur {
    private static final GaussianBlur sInstance = new GaussianBlur();

    public static GaussianBlur getInstance() {
        return sInstance;
    }

    public void setScreenWidth(Context context) {}

    public Bitmap generateGaussianBitmap(Bitmap bitmap, int radius, float scale, boolean hasAlpha) {
        return bitmap;
    }

    public Bitmap generateGaussianBitmap(Bitmap bitmap, int radius, float scale, boolean hasAlpha, boolean recycle) {
        return bitmap;
    }

    public Bitmap generateGaussianBitmap(Bitmap bitmap, boolean hasAlpha) {
        return bitmap;
    }

    public Bitmap generateGaussianBitmapTask(Bitmap bitmap, int radius, float scale, boolean hasAlpha, boolean recycle) {
        return bitmap;
    }
}
