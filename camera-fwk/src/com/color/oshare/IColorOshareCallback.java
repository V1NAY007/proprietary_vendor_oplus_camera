package com.color.oshare;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IColorOshareCallback extends IInterface {
    abstract class Stub extends Binder implements IColorOshareCallback {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
