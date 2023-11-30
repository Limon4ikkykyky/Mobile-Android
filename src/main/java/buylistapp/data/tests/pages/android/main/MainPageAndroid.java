package buylistapp.data.tests.pages.android.main;

import buylistapp.data.tests.pages.base.buylist.AbstractBuyListPage;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;
import buylistapp.data.tests.pages.base.mylist.AbstractMyListPage;
import buylistapp.data.tests.pages.base.settings.AbstractSettingsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

    public class MainPageAndroid extends AbstractMainPage {

        @Override
        @Step("Insert name of new buy list {0}")
        public AbstractMainPage insertNameOfNewBuyList(String buyListName) {
            fieldForNewBuyList.sendKeys(buyListName);
            return this;
        }

        @Override
        @Step("Save new buy list")
        public AbstractBuyListPage saveNewBuyList() {
            buttonSaveNewBuyList.click();
            return AbstractBuyListPage.getInstance();
        }

        @Override
        @Step("Delete list with name {0}")
        public AbstractMainPage deleteBuyList(String buyListName) {
            logger.info("Delete buy list with name " + buyListName);
            wait.whenClickableAndClick(xPath.findNextElementsByText(buyListName, 3));
            logger.info("Confirm to delete buy list in pop up");
            okPopUpBuyList.click();
            return this;
        }

        @Override
        @Step("Check is buy list with name - {0} was deleted")
        public boolean isBuyListPresentOnScreen(String buyListName) {
            try {
                return automator.findByTextContainsWithScroll(buyListName).isDisplayed();
            } catch (NoSuchElementException exception) {
                return false;
            }
        }

        @Override
        @Step("Change actual name {0} of buy list to {1}")
        public AbstractMainPage changeNameOfBuyList(String actualName, String newNameForBuyList) {
            wait.whenClickableAndClick(xPath.findNextElementsByText(actualName, 2));
            WebElement textEditorForNameOfBuyList = wait.whenClickableXPathByText(actualName);
            textEditorForNameOfBuyList.clear();
            textEditorForNameOfBuyList.sendKeys(newNameForBuyList);
            okPopUpBuyList.click();
            return this;
        }

        @Override
        @Step("Open buy list with name {0}")
        public AbstractBuyListPage openBuyListWithName(String buyListName) {
            logger.info("Open buy list with name " + buyListName);
            automator.findByTextContainsWithScroll(buyListName).click();
            return AbstractBuyListPage.getInstance();
        }

        @Override
        @Step("Open menu")
        public AbstractMainPage openMenu() {
            buttonMenu.click();
            return this;
        }

        @Override
        @Step("Open settings")
        public AbstractSettingsPage openSettings() {
            buttonSettings.click();
            return AbstractSettingsPage.getInstance();
        }

        @Override
        @Step("Create buy list with name {0}")
        public AbstractBuyListPage createBuyList(String buyListName) {
            return insertNameOfNewBuyList(buyListName)
                    .saveNewBuyList();
        }

        @Override
        @Step("Open My List")
        public AbstractMyListPage openMyList() {
            buttonMyList.click();
            return AbstractMyListPage.getInstance();
        }

        @Override
        @Step("Add buy list with name {0}")
        public AbstractBuyListPage addBuyList(String buyListName) {
            return insertNameOfNewBuyList(buyListName)
                    .saveNewBuyList();
        }
}
