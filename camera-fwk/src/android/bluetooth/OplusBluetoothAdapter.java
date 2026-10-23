package android.bluetooth;

public class OplusBluetoothAdapter {
    private static OplusBluetoothAdapter sInstance = null;

    public static synchronized OplusBluetoothAdapter getOplusBluetoothAdapter() {
        if (sInstance == null) {
            sInstance = new OplusBluetoothAdapter();
        }
        return sInstance;
    }

    public boolean isBluetoothRecordConnected() {
        return false;
    }
}
