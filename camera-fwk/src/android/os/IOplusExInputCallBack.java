package android.os;

public interface IOplusExInputCallBack extends IInterface {
    abstract class Stub extends Binder implements IOplusExInputCallBack {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
