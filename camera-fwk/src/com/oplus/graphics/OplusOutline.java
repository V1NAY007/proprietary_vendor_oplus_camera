package com.oplus.graphics;

import android.graphics.Outline;
import android.graphics.Rect;

public class OplusOutline {
    private final Outline mOutline;

    public OplusOutline() {
        mOutline = null;
    }

    public OplusOutline(Outline outline) {
        mOutline = outline;
    }

    public void setSmoothRoundRect(int left, int top, int right, int bottom, float rx, float ry) {
        if (mOutline != null) {
            mOutline.setRoundRect(left, top, right, bottom, rx);
        }
    }

    public void setSmoothRoundRect(Rect rect, float rx, float ry) {
        if (mOutline != null && rect != null) {
            mOutline.setRoundRect(rect, rx);
        }
    }
}
