package buylistapp.data.tests.pages.android.settings;

import buylistapp.data.Data.Currency;
import buylistapp.data.tests.pages.base.categories.AbstractEditCategoriesPage;
import buylistapp.data.tests.pages.base.main.AbstractGoToMainPage;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;
import buylistapp.data.tests.pages.base.settings.AbstractSettingsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

public class SettingsPageAndroid extends AbstractSettingsPage {

    @Override
    @Step("Open currency pop up")
    public AbstractSettingsPage openCurrencyPopUp() {
        buttonCurrency.click();
        return this;
    }

    @Override
    @Step("Chosen currency {0}")
    public AbstractSettingsPage chooseCurrency(Currency currency) {
        automator.findByTextContains(currency.getValue()).click();
        return this;
    }

    @Override
    @Step("Is chosen currency equal to {0}")
    public boolean isChosenCurrencyEqualTo(Currency currency) {
        try {
            return automator.isDisplayedByTextWithScroll(currency.getValue());
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    @Override
    @Step("Go to main page")
    public AbstractMainPage goToMainPage() {
        return AbstractGoToMainPage.getInstance().go();
    }

    @Override
    @Step("Choose own currency {0}")
    public AbstractSettingsPage chooseOwnCurrency(String ownCurrency) {
        buttonOwnCurrency.click();
        fieldOwnCurrency.clear();
        fieldOwnCurrency.sendKeys(ownCurrency);
        Currency.OTHER.setValue(ownCurrency);
        buttonOk.click();
        return this;
    }

    @Override
    @Step("Open edit categories")
    public AbstractEditCategoriesPage openEditCategories() {
        buttonCategoriesList.click();
        return AbstractEditCategoriesPage.getInstance();
    }
}
