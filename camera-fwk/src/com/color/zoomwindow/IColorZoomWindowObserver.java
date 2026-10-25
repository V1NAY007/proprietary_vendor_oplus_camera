package com.color.zoomwindow;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IColorZoomWindowObserver extends IInterface {
    abstract class Stub extends Binder implements IColorZoomWindowObserver {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }

    class Default implements IColorZoomWindowObserver {
        public Default() {}

        @Override
        public IBinder asBinder() {
            return null;
        }
    }
}
