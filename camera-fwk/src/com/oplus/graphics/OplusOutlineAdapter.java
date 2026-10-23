package com.oplus.graphics;

import android.graphics.Outline;
import android.graphics.Rect;

public class OplusOutlineAdapter {
    private final Outline mOutline;

    public OplusOutlineAdapter() {
        mOutline = null;
    }

    public OplusOutlineAdapter(Outline outline, int mode) {
        mOutline = outline;
    }

    public static void setSmoothRoundRect(Outline outline, Rect rect, float radius) {
        if (outline != null && rect != null) {
            outline.setRoundRect(rect, radius);
        }
    }

    public static void setSmoothRoundRect(Rect rect, float radius) {}

    public static void setSmoothRoundRect(Rect rect, float[] radii) {}

    public static void setSmoothRoundRect(Rect rect, float[] radii, float weight) {}
}
