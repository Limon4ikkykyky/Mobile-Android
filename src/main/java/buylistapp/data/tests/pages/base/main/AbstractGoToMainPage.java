package buylistapp.data.tests.pages.base.main;

import buylistapp.data.tests.elements.main.GoToMainPageElements;
import buylistapp.data.tests.pages.android.main.GoToMainPageAndroid;

public abstract class AbstractGoToMainPage extends GoToMainPageElements {

    public static AbstractGoToMainPage getInstance() {
        return  new GoToMainPageAndroid();
    }

    public AbstractMainPage go() {
        return AbstractMainPage.getInstance();
    }
}
