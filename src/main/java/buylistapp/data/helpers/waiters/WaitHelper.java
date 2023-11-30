package buylistapp.data.helpers.waiters;

import buylistapp.data.helpers.BaseHelper;
import buylistapp.data.helpers.xpath.XPathHelper;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper extends BaseHelper {

    @Step("Wait for element {0} when it be clickable")
    public MobileElement whenClickable(MobileElement element) {
        logger.info("Wait element " + element.getAttribute("className") + " | " + element.getText());
        return (MobileElement) new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    @Step("Wait for element {0} when it clickable with {1} timeout")
    public MobileElement whenClickable(MobileElement element, long ownTimeOut) {
        logger.info("Wait element " + element.getAttribute("className") + " | " + element.getText());
        return (MobileElement) new WebDriverWait(driver, ownTimeOut)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    @Step("Wait for element {0} when it clickable and click")
    public void whenClickableAndClick(MobileElement element) {
        logger.info("Wait element " + element.getId() + " and click");
        new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    @Step("Wait for element {0} and send keys - {1}")
    public void whenClickableAndSendKeys(MobileElement element, String keys) {
        logger.info("Wait element " + element.getAttribute("className") + " | " + element.getText() + " and send keys - " + keys);
        new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.visibilityOf(element))
                .sendKeys(keys);
    }

    @Step("Check element {0} is clickable and is displayed now")
    public boolean whenClickableAndIsDisplayed(MobileElement element) {
        logger.info("Wait element " + element.getId() + " to be displayed");
        try {
            return new WebDriverWait(driver, timeOut)
                    .until(ExpectedConditions.elementToBeClickable(element))
                    .isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    @Step("Wait and click on mobile element {0}")
    public void whenClickableAndClick(By by) {
        logger.info("Wait and click on mobile element " + by);
        new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.elementToBeClickable(by))
                .click();
    }

    @Step("Wait element with text {0}")
    public MobileElement whenClickableXPathByText(String text) {
        logger.info("Wait element with text " + text);
        return (MobileElement) new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='" + text + "']")));
    }

    @Step("Wait for element {0} when it be clickable")
    public WebElement whenClickable(WebElement element) {
        logger.info("Wait element " + element.getAttribute("className") + " | " + element.getText());
        return new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement whenClickableAndFindByNextElements(String text, int nextElements) {
        logger.info("Wait when clickable by text " + text + " for " + nextElements + "next elements");
        return whenClickable(new XPathHelper().findNextElementsByText(text, nextElements));
    }
}
