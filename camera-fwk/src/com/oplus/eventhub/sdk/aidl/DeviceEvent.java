package com.oplus.eventhub.sdk.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceEvent implements Parcelable {
    public DeviceEvent() {}
    public DeviceEvent(Parcel in) {}

    public int getEventStateType() { return 0; }
    public int getEventType() { return 0; }

    public static class Builder {
        public Builder() {}
        public Builder setEventStateType(int state) { return this; }
        public Builder setEventType(int type) { return this; }
        public DeviceEvent build() { return new DeviceEvent(); }
    }

    @Override
    public int describeContents() { return 0; }
    @Override
    public void writeToParcel(Parcel dest, int flags) {}
    public static final Creator<DeviceEvent> CREATOR = new Creator<DeviceEvent>() {
        @Override
        public DeviceEvent createFromParcel(Parcel in) { return new DeviceEvent(in); }
        @Override
        public DeviceEvent[] newArray(int size) { return new DeviceEvent[size]; }
    };
}
