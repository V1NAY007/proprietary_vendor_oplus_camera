package com.coloros.deepthinker.sdk.aidl.proton.deepsleep;

import android.os.Parcel;
import android.os.Parcelable;

public class DeepSleepCluster implements Parcelable {
    public DeepSleepCluster(double d1, double d2) {}
    public DeepSleepCluster(double d1, double d2, double d3) {}
    public DeepSleepCluster(double d1, double d2, double d3, double d4, double d5, double d6) {}
    public DeepSleepCluster(int i, double d1, double d2, double d3) {}
    protected DeepSleepCluster(Parcel in) {}

    public double getSleepTimePeriod() { return 0.0; }

    @Override
    public int describeContents() { return 0; }
    @Override
    public void writeToParcel(Parcel dest, int flags) {}
    public static final Creator<DeepSleepCluster> CREATOR = new Creator<DeepSleepCluster>() {
        @Override
        public DeepSleepCluster createFromParcel(Parcel in) { return new DeepSleepCluster(in); }
        @Override
        public DeepSleepCluster[] newArray(int size) { return new DeepSleepCluster[size]; }
    };
}
