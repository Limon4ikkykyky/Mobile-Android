package buylistapp.data.helpers;

import buylistapp.data.driver.DriverProvider;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.logging.Logger;

public abstract class BaseHelper {
    protected RemoteWebDriver driver = DriverProvider.getDriver();
    protected Logger logger = Logger.getLogger(getClass().getSimpleName());
    protected final long timeOut = 20;
}