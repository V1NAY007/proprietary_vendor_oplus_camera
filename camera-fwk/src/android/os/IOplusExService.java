package android.os;

public interface IOplusExService extends IInterface {
    boolean registerInputEvent(IOplusExInputCallBack callback);
    boolean registerRawInputEvent(IOplusExInputCallBack callback);
    void unregisterInputEvent(IOplusExInputCallBack callback);

    abstract class Stub extends Binder implements IOplusExService {
        public static IOplusExService asInterface(IBinder obj) {
            return null;
        }

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
