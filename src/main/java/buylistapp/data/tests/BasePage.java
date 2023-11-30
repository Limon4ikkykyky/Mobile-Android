package buylistapp.data.tests;

import buylistapp.data.driver.DriverProvider;
import buylistapp.data.helpers.automator.AndroidAutomatorHelper;
import buylistapp.data.helpers.keys.PressKeyHelper;
import buylistapp.data.helpers.waiters.WaitHelper;
import buylistapp.data.helpers.xpath.XPathHelper;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage {
    protected WaitHelper wait;
    protected XPathHelper xPath;
    protected AndroidAutomatorHelper automator;
    protected Logger logger = Logger.getLogger(getClass().getSimpleName());
    protected PressKeyHelper pressKey;

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverProvider.getDriver(), Duration.ofSeconds(10)), this);
        logger.info("Create " + getClass().getSimpleName() + " page");
        wait = new WaitHelper();
        xPath = new XPathHelper();
        automator = new AndroidAutomatorHelper();
        pressKey = new PressKeyHelper();
    }
}
