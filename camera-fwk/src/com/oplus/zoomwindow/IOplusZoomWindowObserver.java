package com.oplus.zoomwindow;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOplusZoomWindowObserver extends IInterface {
    abstract class Stub extends Binder implements IOplusZoomWindowObserver {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }

    class Default implements IOplusZoomWindowObserver {
        public Default() {}

        @Override
        public IBinder asBinder() {
            return null;
        }
    }
}
