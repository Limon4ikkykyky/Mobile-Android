package buylistapp.data.driver.deviceinfo;

import java.util.Random;

public class DeviceNameHelper {
    public static String getName() {
        return "Device" + new Random().nextInt(100);
    }
}
