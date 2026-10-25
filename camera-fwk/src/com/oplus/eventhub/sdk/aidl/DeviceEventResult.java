package com.oplus.eventhub.sdk.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class DeviceEventResult implements Parcelable {
    public DeviceEventResult(int eventType, int stateType, int result, String extra, Bundle bundle) {}
    protected DeviceEventResult(Parcel in) {}

    public int getEventStateType() { return 0; }
    public int getEventType() { return 0; }

    @Override
    public int describeContents() { return 0; }
    @Override
    public void writeToParcel(Parcel dest, int flags) {}
    public static final Creator<DeviceEventResult> CREATOR = new Creator<DeviceEventResult>() {
        @Override
        public DeviceEventResult createFromParcel(Parcel in) { return new DeviceEventResult(in); }
        @Override
        public DeviceEventResult[] newArray(int size) { return new DeviceEventResult[size]; }
    };
}
