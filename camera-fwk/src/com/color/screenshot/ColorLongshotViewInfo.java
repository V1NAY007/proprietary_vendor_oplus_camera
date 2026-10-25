package com.color.screenshot;

import android.os.Parcel;
import android.os.Parcelable;

public class ColorLongshotViewInfo implements Parcelable {
    public ColorLongshotViewInfo() {}

    public ColorLongshotViewInfo(Parcel in) {
        readFromParcel(in);
    }

    public boolean isUnsupported() {
        return false;
    }

    public void readFromParcel(Parcel in) {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {}

    public static final Creator<ColorLongshotViewInfo> CREATOR = new Creator<ColorLongshotViewInfo>() {
        @Override
        public ColorLongshotViewInfo createFromParcel(Parcel in) {
            return new ColorLongshotViewInfo(in);
        }

        @Override
        public ColorLongshotViewInfo[] newArray(int size) {
            return new ColorLongshotViewInfo[size];
        }
    };
}
