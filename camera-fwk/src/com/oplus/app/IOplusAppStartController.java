package com.oplus.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOplusAppStartController extends IInterface {
    abstract class Stub extends Binder implements IOplusAppStartController {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
