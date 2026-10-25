package android.view;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IOplusWindowStateObserver extends IInterface {
    void onWindowStateChange(String pkg, String activity, boolean visible);

    abstract class Stub extends Binder implements IOplusWindowStateObserver {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
