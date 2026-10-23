package android.os;

import java.io.File;

public class OplusBaseEnvironment {
    public static File getOplusCustomDirectory() {
        return new File("/odm");
    }

    public static File getOplusProductDirectory() {
        return new File("/odm");
    }

    public static File getOplusEngineerDirectory() {
        return new File("/odm");
    }

    public static File getOplusVersionDirectory() {
        return new File("/odm");
    }
}
