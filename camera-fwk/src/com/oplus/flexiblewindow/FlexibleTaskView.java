package com.oplus.flexiblewindow;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.concurrent.Executor;

public class FlexibleTaskView extends View {
    public interface Listener {
        default void onInitialized(boolean z) {}
        default void onTaskChanged(int id, ComponentName componentName, Rect rect) {}
    }

    public FlexibleTaskView(Context context) {
        super(context);
    }

    public void init(FlexibleTaskView view, Bundle bundle) {}
    public void release() {}
    public void resize(Rect rect) {}
    public void setListener(Executor executor, Listener listener) {}
    public void setWorkExecutor(FlexibleTaskView view, Executor executor) {}
}
