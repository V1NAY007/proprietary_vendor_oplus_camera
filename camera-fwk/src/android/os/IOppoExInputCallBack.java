package android.os;

public interface IOppoExInputCallBack extends IInterface {
    abstract class Stub extends Binder implements IOppoExInputCallBack {
        public Stub() {}

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
