package com.color.oshare;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IColorOshareInitListener extends IInterface {
    abstract class Stub extends Binder implements IColorOshareInitListener {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
