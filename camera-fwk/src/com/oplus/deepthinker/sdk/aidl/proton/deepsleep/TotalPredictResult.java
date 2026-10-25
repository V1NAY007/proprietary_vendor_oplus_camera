package com.oplus.deepthinker.sdk.aidl.proton.deepsleep;

import android.os.Parcel;
import android.os.Parcelable;

public class TotalPredictResult implements Parcelable {
    public TotalPredictResult() {}
    protected TotalPredictResult(Parcel in) {}

    public DeepSleepCluster getSleepCluster() { return null; }
    public DeepSleepCluster getWakeCluster() { return null; }

    @Override
    public int describeContents() { return 0; }
    @Override
    public void writeToParcel(Parcel dest, int flags) {}
    public static final Creator<TotalPredictResult> CREATOR = new Creator<TotalPredictResult>() {
        @Override
        public TotalPredictResult createFromParcel(Parcel in) { return new TotalPredictResult(in); }
        @Override
        public TotalPredictResult[] newArray(int size) { return new TotalPredictResult[size]; }
    };
}
