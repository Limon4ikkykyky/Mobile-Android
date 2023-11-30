package buylistapp.data.listeners.allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class Screenshot {
    @Step("Check test result status")
    public void takeScreenshotWhenTestFail(ITestResult testResult, RemoteWebDriver driver) {
        if (testResult.getStatus() == 2) {
            Allure.step("Test was fail, driver get screenshot");
            Allure.addAttachment(
                    getClass().getSimpleName(),
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }
}
