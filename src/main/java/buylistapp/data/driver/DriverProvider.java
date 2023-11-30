package buylistapp.data.driver;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.logging.Logger;

import static buylistapp.data.driver.deviceinfo.DeviceIDID.getUDIDById;
import static buylistapp.data.driver.deviceinfo.DeviceNameHelper.getName;
import static buylistapp.data.driver.deviceinfo.PortHelper.getPortById;
import static buylistapp.data.driver.deviceinfo.WDAPortProvider.getPortWDA;
import static buylistapp.data.driver.platform.PlatformConstants.getPlatform;

public class DriverProvider {
    private static final ThreadLocal<RemoteWebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final Logger logger = Logger.getLogger(DriverProvider.class.getSimpleName());

    @SneakyThrows
    @Step("Create driver")
    public static void create(int instance) {
        logger.info("Trying create new driver");
        logger.info("Instance " + instance);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", getPlatform());
        capabilities.setCapability("udid", getUDIDById(instance));
        capabilities.setCapability("wdaLocalPort", getPortWDA());
        capabilities.setCapability("deviceName", getName());
        logger.info("Driver will be created for Android platform");
        capabilities.setCapability("appPackage", "com.slava.buylist");
        capabilities.setCapability("appActivity", "com.slava.buylist.MainActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("noReset", true);
        driverThreadLocal.set(new AndroidDriver<>(new URL("http://127.0.0.1:" + getPortById(instance) + "/wd/hub"), capabilities));
    }


    @Step("Get driver")
    public static RemoteWebDriver getDriver() {
        logger.info("Trying get driver");
        return driverThreadLocal.get();
    }
}
