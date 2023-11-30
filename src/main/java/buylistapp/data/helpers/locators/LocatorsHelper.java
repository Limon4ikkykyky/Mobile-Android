package buylistapp.data.helpers.locators;

public class LocatorsHelper {
    public static final String uiSelector = "new UiSelector()";
    public static final String uiSelectorResourceId = uiSelector + ".resourceId(\"";
    public static final String uiSelectorTextContains = "new UiSelector().textContains(\"";
    public static final String appId = "com.slava.buylist:id/";
    public static final String androidId = "android:id/";
    public static final String uiSelectorResourceIdWithAppId = uiSelectorResourceId + appId;

    public static final String uiSelectorResourceIdWithAndroidId = uiSelectorResourceId + androidId;
    public static final String end = "\")";
    public static final String uiSelectorTextContainsWithScroll = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"";
    public static final String scrollEnd = "\"))";
}
