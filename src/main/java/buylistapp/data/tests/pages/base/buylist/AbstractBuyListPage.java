package buylistapp.data.tests.pages.base.buylist;

import buylistapp.data.Data.ProductCategory;
import buylistapp.data.Data.ProductUnit;
import buylistapp.data.tests.elements.buylist.BuyListPageElements;
import buylistapp.data.tests.pages.android.buylist.BuyListPageAndroid;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;
import buylistapp.data.tests.pages.base.mylist.AbstractMyListPage;

public abstract class AbstractBuyListPage extends BuyListPageElements {
    public static AbstractBuyListPage getInstance() {
        return  new BuyListPageAndroid();
    }

    public boolean isActualNameOfBuyListEqualsToInputted(String buyListName) {
        return false;
    }

    public AbstractMainPage goToMainPage() {
        return AbstractMainPage.getInstance();
    }

    public AbstractBuyListPage insertNameOfNewProduct(String productName) {
        return this;
    }

    public AbstractBuyListPage confirmAddNewProduct() {
        return this;
    }

    public boolean isProductWithNameDisplayed(String productName) {
        return false;
    }

    public AbstractMainPage declineAddNewProduct() {
        return AbstractMainPage.getInstance();
    }

    public AbstractBuyListPage openEditPopUp(String productName) {
        return this;
    }

    public AbstractBuyListPage removeProductOptionInPopUp() {
        return this;
    }

    public AbstractBuyListPage confirmRemoveProduct() {
        return this;
    }

    public AbstractBuyListPage editProductOptionInPopUp() {
        return this;
    }

    public AbstractBuyListPage setPriceForProduct(String productPrice) {
        return this;
    }

    public AbstractBuyListPage setQuantityForProduct(String productQuantity) {
        return this;
    }

    public AbstractBuyListPage setQuantityForProduct(Integer productQuantity) {
        return this;
    }

    public AbstractBuyListPage setCommentForProduct(String productComment) {
        return this;
    }

    public AbstractBuyListPage setUnitForProduct(ProductUnit productUnit) {return this;};

    public AbstractBuyListPage setCategoryForProduct(ProductCategory productCategory) {
        return this;
    }

    public AbstractBuyListPage saveEditedProduct() {
        return this;
    }

    public boolean isProductWithPriceDisplayed(String productName, String productPrice) {
        return false;
    }

    public boolean isProductWithQuantityDisplayed(String productName, String productQuantity) {
        return false;
    }

    public boolean isProductWithCommentDisplayed(String productName, String productComment) {
        return false;
    }

    public boolean isProductWithUnitDisplayed(String productName, ProductUnit productUnit) {
        return false;
    }
    public Double getSumOfBuyList() { return null; }

    public AbstractBuyListPage addProduct(String productName) {return this;}

    public AbstractBuyListPage addProduct(String productName, String productPrice) {return this;}

    public AbstractBuyListPage addProduct(String productName, String productPrice, String productQuantity) {return this;}

    public AbstractBuyListPage addProduct(String productName, String productPrice, ProductCategory productCategory) { return this; }

    public Double countSumOfProduct(String productPrice, Integer productQuantity) {return null;}

    public Double countSumOfProduct(String productPrice, String productQuantity) {return null;}

    public String getCurrencyOfBuyList() { return null; }

    public boolean isCategoryDisplayedInList(ProductCategory category) {
        return false;
    }

    public AbstractBuyListPage cleanFieldNameProduct() {
        return this;
    }

    public AbstractBuyListPage openMenu() {
        return this;
    }

    public AbstractMyListPage openAddFromMyList() {
        return AbstractMyListPage.getInstance();
    }

    public AbstractBuyListPage deleteProduct(String productName) {
        return this;
    }
}
