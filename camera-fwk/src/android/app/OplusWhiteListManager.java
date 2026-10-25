package android.app;

import android.content.Context;
import com.oplus.app.IOplusProtectConnection;
import java.util.ArrayList;

public class OplusWhiteListManager {
    public OplusWhiteListManager(Context context) {}

    public void addStageProtectInfo(String pkg, long time) {}
    public void addStageProtectInfo(String pkg, String tag, long time) {}
    public void addStageProtectInfo(String pkg, String tag, long time, IOplusProtectConnection connection) {}

    public void removeStageProtectInfo(String pkg) {}
    public void removeStageProtectInfo(String pkg, String tag) {}

    public ArrayList<String> getStageProtectListFromPkg(String pkg, int type) {
        return new ArrayList<>();
    }

    public ArrayList<String> getGlobalProcessWhiteList() {
        return new ArrayList<>();
    }

    public ArrayList<String> getGlobalWhiteList() {
        return new ArrayList<>();
    }

    public ArrayList<String> getGlobalWhiteList(int type) {
        return new ArrayList<>();
    }
}
