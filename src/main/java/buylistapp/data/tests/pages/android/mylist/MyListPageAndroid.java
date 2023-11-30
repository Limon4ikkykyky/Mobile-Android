package buylistapp.data.tests.pages.android.mylist;

import buylistapp.data.tests.pages.base.buylist.AbstractBuyListPage;
import buylistapp.data.tests.pages.base.main.AbstractGoToMainPage;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;
import buylistapp.data.tests.pages.base.mylist.AbstractMyListPage;
import io.qameta.allure.Step;

public class MyListPageAndroid extends AbstractMyListPage {

    @Override
    @Step("Add product with name {0}")
    public AbstractMyListPage addProduct(String productName) {
        AbstractBuyListPage.getInstance()
                .insertNameOfNewProduct(productName)
                .confirmAddNewProduct();
        return this;
    }

    @Override
    @Step("Go to main page")
    public AbstractMainPage goToMainPage() {
        return AbstractGoToMainPage.getInstance().go();
    }

    @Override
    @Step("Is My List page displayed")
    public boolean isMyListPageDisplayed() {
        return headerMyList.isDisplayed() && headerMyList.getText().equals("My List");
    }

    @Override
    @Step("Choose product {0} from My List for add to buy list")
    public AbstractBuyListPage chooseProductForAddToBuyList(String productName) {
        automator.findByTextContains(productName).click();
        buttonOk.click();
        return AbstractBuyListPage.getInstance();
    }

    @Override
    @Step("Delete product in My List with name {0}")
    public AbstractMyListPage deleteProduct(String productName) {
        AbstractBuyListPage.getInstance()
                .openEditPopUp(productName)
                .removeProductOptionInPopUp();
        buttonYes.click();
        return this;
    }

    @Override
    @Step("Is product with name {0} displayed")
    public boolean isProductWithNameDisplayed(String productName) {
        return automator.isDisplayedByTextWithScroll(productName);
    }
}