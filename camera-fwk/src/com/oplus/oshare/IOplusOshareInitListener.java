package com.oplus.oshare;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOplusOshareInitListener extends IInterface {
    abstract class Stub extends Binder implements IOplusOshareInitListener {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
