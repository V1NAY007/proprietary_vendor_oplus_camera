package com.oplus.graphics;

import android.graphics.Path;
import android.graphics.RectF;

public class OplusPath {
    private final Path mPath;

    public OplusPath(Path path) {
        mPath = path;
    }

    public void addSmoothRoundRect(RectF rect, float rx, float ry, Path.Direction dir) {
        if (mPath != null && rect != null && dir != null) {
            mPath.addRoundRect(rect, rx, ry, dir);
        }
    }

    public void addSmoothRoundRect(RectF rect, float[] radii, Path.Direction dir) {
        if (mPath != null && rect != null && radii != null && dir != null) {
            mPath.addRoundRect(rect, radii, dir);
        }
    }

    public void addSmoothRoundRect(RectF rect, float[] radii, Path.Direction dir, float weight) {
        addSmoothRoundRect(rect, radii, dir);
    }
}
