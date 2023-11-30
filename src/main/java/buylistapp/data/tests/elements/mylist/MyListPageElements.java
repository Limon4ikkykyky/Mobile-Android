package buylistapp.data.tests.elements.mylist;

import buylistapp.data.tests.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static buylistapp.data.helpers.locators.LocatorsHelper.*;

public class MyListPageElements extends BasePage {

    @AndroidFindBy(uiAutomator = uiSelectorResourceIdWithAppId +  "textView1" + end)
    protected MobileElement headerMyList;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "OK" + end)
    protected MobileElement buttonOk;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "CANCEL" + end)
    protected MobileElement buttonCancel;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "YES" + end)
    protected MobileElement buttonYes;

    @AndroidFindBy(uiAutomator = uiSelectorTextContains + "NO" + end)
    protected MobileElement buttonNo;
}
