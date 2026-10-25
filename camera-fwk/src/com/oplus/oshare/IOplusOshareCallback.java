package com.oplus.oshare;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOplusOshareCallback extends IInterface {
    abstract class Stub extends Binder implements IOplusOshareCallback {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
