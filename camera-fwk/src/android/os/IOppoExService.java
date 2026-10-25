package android.os;

public interface IOppoExService extends IInterface {
    boolean registerInputEvent(IOppoExInputCallBack callback);
    boolean registerRawInputEvent(IOppoExInputCallBack callback);
    void unregisterInputEvent(IOppoExInputCallBack callback);

    abstract class Stub extends Binder implements IOppoExService {
        public static IOppoExService asInterface(IBinder obj) {
            return null;
        }

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
