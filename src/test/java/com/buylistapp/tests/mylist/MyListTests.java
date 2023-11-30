package com.buylistapp.tests.mylist;

import com.buylistapp.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static buylistapp.data.Data.Product.BUY_LIST_NAME;
import static buylistapp.data.Data.Product.PRODUCT_NAME;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MyListTests extends BaseTest {

    @Test(groups = {"ANDROID"})
    @Description("Add product from my list to new buy list")
    @TmsLink("C8")
    public void addProductFromMyList() {
        assertTrue(mainPage.openMenu()
                .openMyList()
                .isMyListPageDisplayed(), "My List page isn't displayed");
        assertTrue(myListPage.addProduct(PRODUCT_NAME)
                .goToMainPage()
                .addBuyList(BUY_LIST_NAME)
                .openMenu()
                .openAddFromMyList()
                .chooseProductForAddToBuyList(PRODUCT_NAME)
                .isProductWithNameDisplayed(PRODUCT_NAME), "Product from My List isn't add");
        assertFalse(buyListPage.goToMainPage()
                .openMenu()
                .openMyList()
                .deleteProduct(PRODUCT_NAME)
                .isProductWithNameDisplayed(PRODUCT_NAME), "Product is displayed");
    }

    @AfterMethod
    public void cleanUp() {
        buyListPage.goToMainPage()
                .deleteBuyList(BUY_LIST_NAME);
    }
}
