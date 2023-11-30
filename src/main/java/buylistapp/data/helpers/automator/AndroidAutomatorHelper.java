package buylistapp.data.helpers.automator;

import buylistapp.data.helpers.BaseHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AndroidAutomatorHelper extends BaseHelper {

    @Step("Trying find element with text {0} by uiAutomator using scroll")
    public MobileElement findByTextContainsWithScroll(String text) {
        logger.info("Trying find element with text " + text + " by uiAutomator");
        return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())"
                + ".scrollIntoView(new UiSelector()" + ".textContains(\"" + text + "\"));"));
    }

    @Step("Trying find element with text {0}")
    public WebElement findByTextContains(String text) {
        logger.info("Trying find element with text " + text + " by uiAutomator");
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + text + "\")"));
    }

    @Step("Trying find element by id {0}")
    public MobileElement findById(String id) {
        logger.info("Trying find element by id " + id);
        return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" + ".scrollIntoView(new UiSelector()" + ".resourceId(\"" + id + "\"));"));
    }

    @Step("Trying find element with text {0} by uiAutomator")
    public MobileElement findByText(String text) {
        logger.info("Trying find element with text " + text + " by uiAutomator");
        return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + text + "\")"));
    }

    @Step("Check element {0} is displayed on screen by uiAutomator")
    public boolean isDisplayedByTextWithScroll(String text) {
        logger.info("Trying find element by text " + text + " and check is displayed");
        try {
            return findByTextContainsWithScroll(text).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    @Step("Check element {0} is displayed on screen by uiAutomator")
    public boolean isDisplayedByText(String text) {
        logger.info("Trying find element by text " + text + " and check is displayed");
        try {
            return findByTextContains(text).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
