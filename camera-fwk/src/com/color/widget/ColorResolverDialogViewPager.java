package com.color.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ColorResolverDialogViewPager extends RelativeLayout {
    public ColorResolverDialogViewPager(Context context) {
        super(context);
    }

    public ColorResolverDialogViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAdapter(ColorPagerAdapter adapter) {}

    public void setCurrentItem(int item) {}

    public void setDisableTouchEvent(boolean disable) {}

    public void setOnPageChangeListener(ColorViewPager.OnPageChangeListener listener) {}
}
