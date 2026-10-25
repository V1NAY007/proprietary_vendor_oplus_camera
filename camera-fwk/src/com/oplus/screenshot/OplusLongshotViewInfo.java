package com.oplus.screenshot;

import android.os.Parcel;
import android.os.Parcelable;

public class OplusLongshotViewInfo implements Parcelable {
    public OplusLongshotViewInfo() {}

    public OplusLongshotViewInfo(Parcel in) {
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

    public static final Creator<OplusLongshotViewInfo> CREATOR = new Creator<OplusLongshotViewInfo>() {
        @Override
        public OplusLongshotViewInfo createFromParcel(Parcel in) {
            return new OplusLongshotViewInfo(in);
        }

        @Override
        public OplusLongshotViewInfo[] newArray(int size) {
            return new OplusLongshotViewInfo[size];
        }
    };
}
