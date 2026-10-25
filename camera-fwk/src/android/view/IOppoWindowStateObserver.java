package android.view;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOppoWindowStateObserver extends IInterface {
    void onWindowStateChange(String pkg, String activity, boolean visible);

    abstract class Stub extends Binder implements IOppoWindowStateObserver {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
