package android.view.animation;

import android.content.Context;
import android.util.AttributeSet;

public class OppoBezierInterpolator extends OplusBezierInterpolator {
    public OppoBezierInterpolator(double x1, double y1, double x2, double y2, boolean isBounded) {
        super(x1, y1, x2, y2, isBounded);
    }

    public OppoBezierInterpolator(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public OppoBezierInterpolator(float x1, float y1, float x2, float y2, boolean isBounded) {
        super(x1, y1, x2, y2, isBounded);
    }

    public OppoBezierInterpolator(float x1, float y1, float x2, float y2) {
        super(x1, y1, x2, y2);
    }

    public OppoBezierInterpolator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OppoBezierInterpolator() {
        super();
    }
}
