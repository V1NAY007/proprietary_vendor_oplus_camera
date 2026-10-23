package com.oplus.hardware.camera2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOplusCameraDeviceCallback extends IInterface {
    String DESCRIPTOR = "com.oplus.hardware.camera2.IOplusCameraDeviceCallback";
    int ERROR_CAMERA_INVALID_ERROR = -1;
    int ERROR_CAMERA_STATELLITE_CONFLICT = 0;

    void onDeviceOpened(int cameraId, String packageName) throws RemoteException;
    void onDisconnected(int cameraId, String packageName) throws RemoteException;
    void onInterceptOpen(int cameraId, String packageName, int errorCode) throws RemoteException;

    class Default implements IOplusCameraDeviceCallback {
        @Override
        public void onDeviceOpened(int cameraId, String packageName) throws RemoteException {}

        @Override
        public void onDisconnected(int cameraId, String packageName) throws RemoteException {}

        @Override
        public void onInterceptOpen(int cameraId, String packageName, int errorCode) throws RemoteException {}

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    abstract class Stub extends Binder implements IOplusCameraDeviceCallback {
        static final int TRANSACTION_onDeviceOpened = 1;
        static final int TRANSACTION_onDisconnected = 2;
        static final int TRANSACTION_onInterceptOpen = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOplusCameraDeviceCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof IOplusCameraDeviceCallback) {
                return (IOplusCameraDeviceCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION:
                    reply.writeString(DESCRIPTOR);
                    return true;
                case TRANSACTION_onDeviceOpened:
                    data.enforceInterface(DESCRIPTOR);
                    onDeviceOpened(data.readInt(), data.readString());
                    return true;
                case TRANSACTION_onDisconnected:
                    data.enforceInterface(DESCRIPTOR);
                    onDisconnected(data.readInt(), data.readString());
                    return true;
                case TRANSACTION_onInterceptOpen:
                    data.enforceInterface(DESCRIPTOR);
                    onInterceptOpen(data.readInt(), data.readString(), data.readInt());
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IOplusCameraDeviceCallback {
            private final IBinder mRemote;

            Proxy(IBinder remote) {
                mRemote = remote;
            }

            @Override
            public IBinder asBinder() {
                return mRemote;
            }

            @Override
            public void onDeviceOpened(int cameraId, String packageName) throws RemoteException {
                Parcel data = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(cameraId);
                    data.writeString(packageName);
                    mRemote.transact(TRANSACTION_onDeviceOpened, data, null, FLAG_ONEWAY);
                } finally {
                    data.recycle();
                }
            }

            @Override
            public void onDisconnected(int cameraId, String packageName) throws RemoteException {
                Parcel data = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(cameraId);
                    data.writeString(packageName);
                    mRemote.transact(TRANSACTION_onDisconnected, data, null, FLAG_ONEWAY);
                } finally {
                    data.recycle();
                }
            }

            @Override
            public void onInterceptOpen(int cameraId, String packageName, int errorCode) throws RemoteException {
                Parcel data = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(cameraId);
                    data.writeString(packageName);
                    data.writeInt(errorCode);
                    mRemote.transact(TRANSACTION_onInterceptOpen, data, null, FLAG_ONEWAY);
                } finally {
                    data.recycle();
                }
            }
        }
    }
}
