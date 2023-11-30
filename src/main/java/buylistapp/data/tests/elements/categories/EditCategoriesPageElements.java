package buylistapp.data.tests.elements.categories;

import buylistapp.data.tests.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static buylistapp.data.helpers.locators.LocatorsHelper.*;

public class EditCategoriesPageElements extends BasePage {

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "ADD NEW" + end)
    protected MobileElement buttonAddNewCategory;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.EditText")
    protected MobileElement fieldEnterNameOfCategory;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "OK" + end)
    protected MobileElement buttonOk;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "NO" + end)
    protected MobileElement buttonCancel;

    @AndroidFindBy(uiAutomator = uiSelectorResourceId + androidId + "alertTitle" + end)
    protected MobileElement textEnterNameOfNewCategory;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Remove" + end)
    protected MobileElement buttonRemove;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Edit" + end)
    protected MobileElement buttonEdit;
}
