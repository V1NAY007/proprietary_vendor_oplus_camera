package com.oplus.direct;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class OplusDirectFindResult implements Parcelable {
    public OplusDirectFindResult() {}

    protected OplusDirectFindResult(Parcel in) {}

    public Bundle getBundle() {
        return new Bundle();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {}

    public static final Creator<OplusDirectFindResult> CREATOR = new Creator<OplusDirectFindResult>() {
        @Override
        public OplusDirectFindResult createFromParcel(Parcel in) {
            return new OplusDirectFindResult(in);
        }

        @Override
        public OplusDirectFindResult[] newArray(int size) {
            return new OplusDirectFindResult[size];
        }
    };
}
