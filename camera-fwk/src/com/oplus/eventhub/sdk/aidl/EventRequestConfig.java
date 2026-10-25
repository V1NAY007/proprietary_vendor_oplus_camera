package com.oplus.eventhub.sdk.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArraySet;
import java.util.HashSet;

public class EventRequestConfig implements Parcelable {
    public EventRequestConfig(ArraySet<?> set) {}
    protected EventRequestConfig(Parcel in) {}

    public HashSet<?> getAllEvents() { return new HashSet<>(); }
    public ArraySet<?> getDeviceEventSet() { return new ArraySet<>(); }

    @Override
    public int describeContents() { return 0; }
    @Override
    public void writeToParcel(Parcel dest, int flags) {}
    public static final Creator<EventRequestConfig> CREATOR = new Creator<EventRequestConfig>() {
        @Override
        public EventRequestConfig createFromParcel(Parcel in) { return new EventRequestConfig(in); }
        @Override
        public EventRequestConfig[] newArray(int size) { return new EventRequestConfig[size]; }
    };
}
