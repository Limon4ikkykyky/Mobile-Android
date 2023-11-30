package buylistapp.data.tests.elements.settings;

import buylistapp.data.tests.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static buylistapp.data.helpers.locators.LocatorsHelper.*;

public class SettingsPageElements extends BasePage {

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Currency" + end)
    protected MobileElement buttonCurrency;

    @AndroidFindBy(id = appId + "textView1")
    protected MobileElement headerMainPage;

    @AndroidFindBy(uiAutomator = uiSelectorTextContainsWithScroll + "Own currency" + scrollEnd)
    protected MobileElement buttonOwnCurrency;

    @AndroidFindBy(uiAutomator = uiSelectorResourceId + androidId + "edit" + end)
    protected MobileElement fieldOwnCurrency;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "OK" + end)
    protected MobileElement buttonOk;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Cancel" + end)
    protected MobileElement buttonCancel;

    @AndroidFindBy(uiAutomator = uiSelectorTextContainsWithScroll + "Categories List" + scrollEnd)
    protected MobileElement buttonCategoriesList;
}
