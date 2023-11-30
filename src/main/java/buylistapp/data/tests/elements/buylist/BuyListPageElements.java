package buylistapp.data.tests.elements.buylist;

import buylistapp.data.tests.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static buylistapp.data.helpers.locators.LocatorsHelper.*;

public class BuyListPageElements extends BasePage {

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "editText1" + end)
    protected MobileElement fieldAddProduct;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "button2" + end)
    protected MobileElement buttonAddProduct;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Save current item?\")")
    protected MobileElement saveItemPopUp;

    @AndroidFindBy(uiAutomator = uiSelectorResourceId + androidId + "button2" + end)
    protected MobileElement buttonNoSaveProduct;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Remove" + end)
    protected MobileElement buttonRemoveProduct;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "YES" + end)
    protected MobileElement buttonYesInAlertConfirm;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Edit" + end)
    protected MobileElement buttonEditProduct;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "editText2" + end)
    protected MobileElement priceField;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "editText3" + end)
    protected MobileElement quantityField;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "editText4" + end)
    protected MobileElement commentField;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "spinner1" + end)
    protected MobileElement unitSpinner;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "spinner2" + end)
    protected MobileElement categorySpinner;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "textView2" + end)
    protected MobileElement totalSumOfBuyList;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "button1" + end)
    protected MobileElement buttonMenu;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Add from my list" + end)
    protected MobileElement buttonAddFromMyList;
}
