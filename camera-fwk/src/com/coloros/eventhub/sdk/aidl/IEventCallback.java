package com.coloros.eventhub.sdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IEventCallback extends IInterface {
    abstract class Stub extends Binder implements IEventCallback {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
