package buylistapp.data.helpers.xpath;

import buylistapp.data.helpers.BaseHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class XPathHelper extends BaseHelper {

    @Step("Find element by xpath with text {0}")
    public MobileElement findByText(String text) {
        logger.info("Find element by xpath with text - " + text);
        return (MobileElement) driver.findElement(By.xpath("//*[@text='" + text + "']"));
    }

    @Step("Find next {1} elements by text - {0}")
    public MobileElement findNextElementsByText(String text, int nextElements) {
        logger.info("Find by text " + text + " with uiAutomator for " + nextElements + "next elements");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())"
                + ".scrollIntoView(new UiSelector()" + ".textContains(\"" + text + "\"));"));
        return (MobileElement) driver.findElement(By.xpath("//*[@text='" + text + "']/following-sibling::*[" + nextElements + "]"));
    }
}
