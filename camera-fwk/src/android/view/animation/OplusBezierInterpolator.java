package android.view.animation;

import android.content.Context;
import android.util.AttributeSet;

public class OplusBezierInterpolator implements Interpolator {
    private static final int NUM_SEARCH_STEPS = 16;
    private final double mX1;
    private final double mY1;
    private final double mX2;
    private final double mY2;
    private final boolean mIsBounded;

    public OplusBezierInterpolator(double x1, double y1, double x2, double y2, boolean isBounded) {
        mX1 = x1;
        mY1 = y1;
        mX2 = x2;
        mY2 = y2;
        mIsBounded = isBounded;
    }

    public OplusBezierInterpolator(double x1, double y1, double x2, double y2) {
        this(x1, y1, x2, y2, true);
    }

    public OplusBezierInterpolator(float x1, float y1, float x2, float y2, boolean isBounded) {
        this((double) x1, (double) y1, (double) x2, (double) y2, isBounded);
    }

    public OplusBezierInterpolator(float x1, float y1, float x2, float y2) {
        this((double) x1, (double) y1, (double) x2, (double) y2, true);
    }

    public OplusBezierInterpolator(Context context, AttributeSet attrs) {
        this(0.25, 0.1, 0.25, 1.0, true);
    }

    public OplusBezierInterpolator() {
        this(0.25, 0.1, 0.25, 1.0, true);
    }

    @Override
    public float getInterpolation(float input) {
        if (input <= 0.0f) {
            return 0.0f;
        }
        if (input >= 1.0f) {
            return 1.0f;
        }

        double low = 0.0;
        double high = 1.0;
        double t = 0.5;

        for (int i = 0; i < NUM_SEARCH_STEPS; i++) {
            t = (low + high) * 0.5;
            double currentX = getCoordinate(t, mX1, mX2);
            if (currentX < input) {
                low = t;
            } else {
                high = t;
            }
        }

        double y = getCoordinate(t, mY1, mY2);
        if (mIsBounded) {
            if (y < 0.0) y = 0.0;
            if (y > 1.0) y = 1.0;
        }
        return (float) y;
    }

    private static double getCoordinate(double t, double p1, double p2) {
        double oneMinusT = 1.0 - t;
        return 3.0 * oneMinusT * oneMinusT * t * p1 + 3.0 * oneMinusT * t * t * p2 + t * t * t;
    }
}
