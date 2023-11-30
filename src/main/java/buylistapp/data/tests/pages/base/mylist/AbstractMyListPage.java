package buylistapp.data.tests.pages.base.mylist;

import buylistapp.data.tests.elements.mylist.MyListPageElements;
import buylistapp.data.tests.pages.android.mylist.MyListPageAndroid;
import buylistapp.data.tests.pages.base.buylist.AbstractBuyListPage;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;

public abstract class AbstractMyListPage extends MyListPageElements {

    public static AbstractMyListPage getInstance() {
        return  new MyListPageAndroid();
    }

    public AbstractMyListPage addProduct(String productName) {
        return this;
    }

    public AbstractMainPage goToMainPage() {
        return AbstractMainPage.getInstance();
    }

    public boolean isMyListPageDisplayed() {
        return false;
    }

    public AbstractBuyListPage chooseProductForAddToBuyList(String productName) {
        return AbstractBuyListPage.getInstance();
    }

    public AbstractMyListPage deleteProduct(String productName) {
        return this;
    }

    public boolean isProductWithNameDisplayed(String productName) {
        return false;
    }
}
