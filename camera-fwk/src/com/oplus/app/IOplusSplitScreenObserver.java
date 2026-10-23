package com.oplus.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface IOplusSplitScreenObserver extends IInterface {
    void onStateChanged(String str, Bundle bundle) throws RemoteException;

    abstract class Stub extends Binder implements IOplusSplitScreenObserver {
        public Stub() {
            attachInterface(this, "com.oplus.app.IOplusSplitScreenObserver");
        }

        public static IOplusSplitScreenObserver asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("com.oplus.app.IOplusSplitScreenObserver");
            if (iin instanceof IOplusSplitScreenObserver) {
                return (IOplusSplitScreenObserver) iin;
            }
            return null;
        }

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
