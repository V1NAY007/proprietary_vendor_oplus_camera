package com.oplus.wrapper.graphics;

public class HardwareRenderer {
    public interface FrameDrawingCallback {
        void onFrameDraw(long frame);
    }

    public static void setContextPriority(int priority) {}
}
