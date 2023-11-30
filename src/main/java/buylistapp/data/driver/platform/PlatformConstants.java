package buylistapp.data.driver.platform;

public class PlatformConstants {
    public final static boolean IS_IOS = DriverType.IOS.toString().equalsIgnoreCase(System.getProperty("platform"));
    public final static boolean IS_ANDROID = DriverType.ANDROID.toString().equalsIgnoreCase(System.getProperty("platform"));

    public static String getPlatform() {
        return System.getProperty("platform");
    }

    public enum DriverType {
        ANDROID,
        IOS
    }
}
