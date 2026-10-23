package android.hardware.display;

public class OplusDisplayManager {
    private static final OplusDisplayManager sInstance = new OplusDisplayManager();

    public static OplusDisplayManager getInstance() {
        return sInstance;
    }

    public void setSpecEnvironmentNit(int scene, int nit, int rate) {}
}
