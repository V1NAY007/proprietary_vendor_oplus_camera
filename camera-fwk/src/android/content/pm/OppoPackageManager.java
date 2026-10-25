package android.content.pm;

import android.content.Context;

public class OppoPackageManager extends OplusPackageManager {
    public OppoPackageManager() {
        super();
    }

    public OppoPackageManager(Context context) {
        super(context);
    }

    public int getOppoFreezePackageState(String pkg, int userId) {
        return getOplusFreezePackageState(pkg, userId);
    }

    public int oppoUnFreezePackage(String pkg, int state, int flags, int userId, String reason) {
        return oplusUnFreezePackage(pkg, state, flags, userId, reason);
    }
}
