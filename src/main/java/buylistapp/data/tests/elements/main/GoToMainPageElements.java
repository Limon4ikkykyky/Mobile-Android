package buylistapp.data.tests.elements.main;

import buylistapp.data.tests.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static buylistapp.data.helpers.locators.LocatorsHelper.*;

public class GoToMainPageElements extends BasePage {

    @AndroidFindBy(uiAutomator = uiSelectorResourceId + appId + "textView1" + end)
    protected MobileElement headerMainPage;

    @AndroidFindBy(uiAutomator = uiSelectorResourceId + appId + "button1" + end)
    protected MobileElement buttonMenu;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Save current item?" + end)
    protected MobileElement textSaveCurrentItem;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "NO" + end)
    protected MobileElement buttonNo;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "Buy list" + end)
    protected MobileElement textHeaderMainPage;
}
