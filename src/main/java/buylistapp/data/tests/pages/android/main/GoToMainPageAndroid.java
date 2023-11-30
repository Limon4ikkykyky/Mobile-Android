package buylistapp.data.tests.pages.android.main;

import buylistapp.data.tests.pages.base.main.AbstractGoToMainPage;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
    public class GoToMainPageAndroid extends AbstractGoToMainPage {

        @Override
        @Step("Go to main page")
        public AbstractMainPage go() {
            boolean isMainPage = false;
            while (!isMainPage) {
                try {
                    logger.info("Trying check is that main page");
                    isMainPage = productPopUpHandle();
                    isMainPage = headerMainPage.isDisplayed()
                            && textHeaderMainPage.isDisplayed()
                            && buttonMenu.isDisplayed();
                } catch (NoSuchElementException | StaleElementReferenceException | AssertionError exception) {
                    logger.info("This page isn't main, go back");
                    pressKey.androidPressBack();
                }
            }
            return AbstractMainPage.getInstance();
        }

        private boolean productPopUpHandle() {
            try {
                if (textSaveCurrentItem.isDisplayed()) {
                    buttonNo.click();
                    return true;
                }
            } catch (NoSuchElementException | StaleElementReferenceException | AssertionError ignored) {}
            return false;
        }
}
