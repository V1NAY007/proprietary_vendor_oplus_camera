package com.color.widget;

public class ColorViewPager {
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int state);
        void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
        void onPageSelected(int position);
    }
}
