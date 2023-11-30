package buylistapp.data.tests.pages.base.main;

import buylistapp.data.tests.elements.main.MainPageElements;
import buylistapp.data.tests.pages.android.main.MainPageAndroid;
import buylistapp.data.tests.pages.base.buylist.AbstractBuyListPage;
import buylistapp.data.tests.pages.base.mylist.AbstractMyListPage;
import buylistapp.data.tests.pages.base.settings.AbstractSettingsPage;

public abstract class AbstractMainPage extends MainPageElements {
    public static AbstractMainPage getInstance() {
        return  new MainPageAndroid();
    }

    public AbstractMainPage insertNameOfNewBuyList(String buyListName) {
        return this;
    }

    public AbstractBuyListPage saveNewBuyList() {
        return AbstractBuyListPage.getInstance();
    }

    public AbstractMainPage deleteBuyList(String buyListName) {
        return this;
    }

    public boolean isBuyListPresentOnScreen(String buyListName) {
        return false;
    }

    public AbstractMainPage changeNameOfBuyList(String actualName, String newNameForBuyList) {
        return this;
    }

    public AbstractBuyListPage openBuyListWithName(String buyListName) {
        return AbstractBuyListPage.getInstance();
    }

    public AbstractMainPage openMenu() {
        return this;
    }

    public AbstractSettingsPage openSettings() {
        return AbstractSettingsPage.getInstance();
    }

    public AbstractBuyListPage createBuyList(String buyListName) {
        return AbstractBuyListPage.getInstance();
    }

    public AbstractMyListPage openMyList() {
        return AbstractMyListPage.getInstance();
    }

    public AbstractBuyListPage addBuyList(String buyListName) {
        return AbstractBuyListPage.getInstance();
    }
}
