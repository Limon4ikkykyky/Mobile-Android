package buylistapp.data.tests.pages.base.settings;

import buylistapp.data.Data.Currency;
import buylistapp.data.tests.elements.settings.SettingsPageElements;

import buylistapp.data.tests.pages.android.settings.SettingsPageAndroid;
import buylistapp.data.tests.pages.base.categories.AbstractEditCategoriesPage;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;

public abstract class AbstractSettingsPage extends SettingsPageElements {

    public static AbstractSettingsPage getInstance() {
        return  new SettingsPageAndroid();
    }

    public AbstractSettingsPage openCurrencyPopUp() {
        return this;
    }

    public AbstractSettingsPage chooseCurrency(Currency currency) {
        return this;
    }

    public boolean isChosenCurrencyEqualTo(Currency currency) {
        return false;
    }

    public AbstractMainPage goToMainPage() {
        return AbstractMainPage.getInstance();
    }

    public AbstractSettingsPage chooseOwnCurrency(String ownCurrency) {
        return this;
    }

    public AbstractEditCategoriesPage openEditCategories() {return AbstractEditCategoriesPage.getInstance();}
}
