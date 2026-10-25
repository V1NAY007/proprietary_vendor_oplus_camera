package com.color.direct;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class ColorDirectFindResult implements Parcelable {
    public ColorDirectFindResult() {}

    protected ColorDirectFindResult(Parcel in) {}

    public Bundle getBundle() {
        return new Bundle();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {}

    public static final Creator<ColorDirectFindResult> CREATOR = new Creator<ColorDirectFindResult>() {
        @Override
        public ColorDirectFindResult createFromParcel(Parcel in) {
            return new ColorDirectFindResult(in);
        }

        @Override
        public ColorDirectFindResult[] newArray(int size) {
            return new ColorDirectFindResult[size];
        }
    };
}
