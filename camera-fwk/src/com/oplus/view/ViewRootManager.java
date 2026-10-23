package com.oplus.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.oplus.graphics.OplusBlurParam;

public class ViewRootManager {
    public ViewRootManager(View view) {}

    public Drawable getBackgroundBlurDrawable() {
        return null;
    }

    public void setBlurParams(OplusBlurParam params) {}
    public void setBlurRadius(int radius) {}
    public void setColor(int color) {}
    public void setCornerRadius(float r1, float r2, float r3, float r4) {}
}
