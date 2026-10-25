package com.oplus.oiface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOIfaceCallback extends IInterface {
    abstract class Stub extends Binder implements IOIfaceCallback {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
