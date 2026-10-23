package android.app;

import android.content.ComponentName;
import com.oplus.app.OplusTaskInfoChangeListener;
import java.util.ArrayList;
import java.util.List;

public class OplusActivityTaskManager {
    private static OplusActivityTaskManager sInstance = null;

    public OplusActivityTaskManager() {}

    public static synchronized OplusActivityTaskManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusActivityTaskManager();
        }
        return sInstance;
    }

    public ComponentName getTopActivityComponentName() {
        return null;
    }

    public List<Object> getVisibleTasks(int maxNum) {
        return new ArrayList<>();
    }

    public boolean registerTaskInfoChangeListener(OplusTaskInfoChangeListener listener, int type, int flags) {
        return false;
    }

    public boolean unregisterTaskInfoChangeListener(OplusTaskInfoChangeListener listener) {
        return false;
    }
}
