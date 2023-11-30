package buylistapp.data.driver.deviceinfo;

import java.util.Random;

public class WDAPortProvider {
    public static String getPortWDA() {
        return String.valueOf(8000 + new Random().nextInt(100));
    }
}
