package android.hardware.camera2;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;

public class OplusCameraManager implements IOplusCameraManager {

    private static final String TAG = "OplusCameraManager";
    private static OplusCameraManager sInstance = null;

    public static synchronized OplusCameraManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusCameraManager();
        }
        return sInstance;
    }

    @Override
    public void preOpenCamera(Context context) {
        Log.d(TAG, "preOpenCamera called");
    }

    @Override
    public void setCallInfo() {
        Log.d(TAG, "setCallInfo called");
    }

    @Override
    public void setDeathRecipient(IBinder client) {
        Log.d(TAG, "setDeathRecipient called");
    }

    public void setDeathRecipient(Context context, IBinder client) {
        Log.d(TAG, "setDeathRecipient called with context");
    }

    @Override
    public void sendOplusExtCamCmd(Context context, IOplusCameraManager.Cmd cmd, int[] param) {
        Log.d(TAG, "sendOplusExtCamCmd called: " + cmd);
    }

    public void sendOplusExtCamCmd(Context context, Object cmd, int[] param) {
        Log.d(TAG, "sendOplusExtCamCmd (Object) called: " + cmd);
    }

    public void sendOplusExtCamCmdWithReply(Context context, IOplusCameraManager.Cmd cmd, int[] param, StringBuilder result) {
        Log.d(TAG, "sendOplusExtCamCmdWithReply called: " + cmd);
    }

    public void sendOplusExtCamCmdWithReply(Context context, Object cmd, int[] param, StringBuilder result) {
        Log.d(TAG, "sendOplusExtCamCmdWithReply (Object) called: " + cmd);
    }

    public void readMemoryInfo(IOplusCameraManager.Cmd cmd, StringBuilder sb, int flags) {}
    public void reportAppFreeze(int pid, boolean freeze) {}

    public android.hardware.camera2.impl.CameraMetadataNative getEmptyCameraMetadataNative() {
        return new android.hardware.camera2.impl.CameraMetadataNative();
    }
}
