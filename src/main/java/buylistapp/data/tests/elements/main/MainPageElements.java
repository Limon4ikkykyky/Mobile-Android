package buylistapp.data.tests.elements.main;

import buylistapp.data.tests.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static buylistapp.data.helpers.locators.LocatorsHelper.*;

public class MainPageElements extends BasePage {

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "editText1" + end)
    protected MobileElement fieldForNewBuyList;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "button2" + end)
    protected MobileElement buttonSaveNewBuyList;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAndroidId + "button1" + end)
    protected MobileElement okPopUpBuyList;

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId + "button1" + end)
    protected MobileElement buttonMenu;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Settings" + end)
    protected MobileElement buttonSettings;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "My List" + end)
    protected MobileElement buttonMyList;
}
