package com.oplus.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface IOplusProtectConnection extends IInterface {
    void onError(int error) throws RemoteException;
    void onSuccess() throws RemoteException;
    void onTimeout() throws RemoteException;

    abstract class Stub extends Binder implements IOplusProtectConnection {
        public Stub() {
            attachInterface(this, "com.oplus.app.IOplusProtectConnection");
        }

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
