package com.oplus.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class OplusResolverDialogViewPager extends RelativeLayout {
    public OplusResolverDialogViewPager(Context context) {
        super(context);
    }

    public OplusResolverDialogViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAdapter(OplusPagerAdapter adapter) {}

    public void setCurrentItem(int item) {}

    public void setDisableTouchEvent(boolean disable) {}

    public void setOnPageChangeListener(OplusViewPager.OnPageChangeListener listener) {}
}
