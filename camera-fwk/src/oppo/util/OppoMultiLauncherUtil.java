package oppo.util;

import java.util.ArrayList;
import java.util.List;

public class OppoMultiLauncherUtil {
    private static final OppoMultiLauncherUtil sInstance = new OppoMultiLauncherUtil();

    public static OppoMultiLauncherUtil getInstance() {
        return sInstance;
    }

    public String getAliasByPackage(String pkg) {
        return null;
    }

    public List<String> getCreatedMultiApp() {
        return new ArrayList<>();
    }
}
