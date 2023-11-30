package buylistapp.data.driver.deviceinfo;

public class PortHelper {
    public static String[] getPorts() {
        return System.getProperties().getProperty("port").split(",");
    }

    public static String getPortById(int id) {
        return getPorts()[id];
    }
}
