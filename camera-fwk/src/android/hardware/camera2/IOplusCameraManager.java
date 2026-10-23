package android.hardware.camera2;

import android.content.Context;
import android.os.IBinder;

public interface IOplusCameraManager {
    String NAME = "IOplusCameraManager";
    IOplusCameraManager DEFAULT = new IOplusCameraManager() {};

    enum Cmd {
        CMD_NONE,
        CMD_PRE_CAPTURE,
        CMD_PRE_OPEN,
        CMD_PRE_EVLIST,
        CMD_READ_MEM,
        CMD_PRE_PRO_MANUAL_WB,
        CMD_UI_EVENT,
        CMD_PRE_CLOSE,
        CMD_CAMERA_CONTROL,
        CMD_OPLUS_SEND_RUS_CONFIG_TO_HAL,
        CMD_OPLUS_FORCE_FALLBACK,
        CMD_OPLUS_FORCE_EIS,
        CMD_OPLUS_OPERATION_MODE,
        CMD_OPLUS_PRO_COLOR,
        CMD_OPLUS_FORCE_FPS,
        CMD_OPLUS_HCS,
        CMD_OPLUS_IO_PRIORITY;
    }

    default void addAuthResultInfo(Context context, int uid, int pid, int permBits, String packageName) {}
    default boolean isAuthedClient(Context context) { return false; }
    default boolean isCameraUnitSession() { return false; }
    default boolean isPrivilegedApp(String packageName) { return false; }
    default void preOpenCamera(Context context) {}
    default void saveOpPackageName(String packageName) {}
    default void sendOplusExtCamCmd(Context context, IOplusCameraManager.Cmd cmd, int[] param) {}
    default void setCallInfo() {}
    default void setDeathRecipient(IBinder client) {}
    default void setPackageName() {}
}
