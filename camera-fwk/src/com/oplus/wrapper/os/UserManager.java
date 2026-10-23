package com.oplus.wrapper.os;

public class UserManager {
    private final android.os.UserManager mUserManager;

    public UserManager(android.os.UserManager userManager) {
        mUserManager = userManager;
    }

    public static android.os.UserManager get(android.content.Context context) {
        return (android.os.UserManager) context.getSystemService(android.content.Context.USER_SERVICE);
    }

    public boolean isGuestUser() {
        return mUserManager != null && mUserManager.isGuestUser();
    }
}
