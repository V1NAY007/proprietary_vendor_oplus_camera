package com.color.widget;

import android.graphics.drawable.Drawable;

public class ColorItem {
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public ColorItem() {}

    public Drawable getIcon() { return null; }
    public String getText() { return null; }
    public OnItemClickListener getOnItemClickListener() { return null; }
    public void setIcon(Drawable icon) {}

    public static class Builder {
        public Builder() {}
        public Builder setBackgroud(int resId) { return this; }
        public Builder setBackgroud(Drawable drawable) { return this; }
        public ColorItem build() { return new ColorItem(); }
    }
}
