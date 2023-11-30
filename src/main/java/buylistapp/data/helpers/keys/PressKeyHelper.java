package buylistapp.data.helpers.keys;

import buylistapp.data.helpers.BaseHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.time.Duration;

public class PressKeyHelper extends BaseHelper {

    public void androidPressBack() {
        logger.info("Press back button in Android platform");
        ((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void longPressOnElement(MobileElement element) {
        logger.info("Long press on element");
        new TouchAction((AndroidDriver) driver).longPress(new LongPressOptions()
                        .withElement(ElementOption.element(element))
                        .withDuration(Duration.ofSeconds(1)))
                .release()
                .perform();
    }

    public boolean isKeyboardShownAndroid() {
        logger.info("Check is android keyboard shown");
        return ((AndroidDriver<?>) driver).isKeyboardShown();
    }

    public void hideKeyboardSafe() {
        logger.info("Hide keyboard safe");
        if (isKeyboardShownAndroid())
            ((AndroidDriver<?>) driver).hideKeyboard();
    }
}