package com.oplus.multiuser;

import android.os.UserHandle;

public class OplusMultiUserManager {
    private static final OplusMultiUserManager sInstance = new OplusMultiUserManager();

    public static OplusMultiUserManager getInstance() {
        return sInstance;
    }

    public boolean isMultiSystemUserHandle(UserHandle handle) {
        return false;
    }
}
