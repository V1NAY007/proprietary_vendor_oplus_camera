package com.oplus.inner.view;

import android.view.View;

public class ViewWrapper {
    public static void setScrollXForColor(View view, int x) {
        if (view != null) {
            view.setScrollX(x);
        }
    }

    public static void setScrollYForColor(View view, int y) {
        if (view != null) {
            view.setScrollY(y);
        }
    }
}
