package com.oppo.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOppoAppStartController extends IInterface {
    abstract class Stub extends Binder implements IOppoAppStartController {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
