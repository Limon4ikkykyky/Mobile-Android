package com.buylistapp.tests.products;

import buylistapp.data.Data.ProductCategory;
import buylistapp.data.Data.ProductUnit;
import com.buylistapp.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static buylistapp.data.Data.Product.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ProductsTests extends BaseTest {

    @Test(groups = {"ANDROID"})
    @Description("Add product in buy list")
    @TmsLink("C9")
    public void addProductInBuyList() {
        assertTrue(mainPage.insertNameOfNewBuyList(BUY_LIST_NAME)
                .saveNewBuyList()
                .insertNameOfNewProduct(PRODUCT_NAME)
                .confirmAddNewProduct()
                .isProductWithNameDisplayed(PRODUCT_NAME), "Product isn't displayed");
    }

    @Test(groups = {"ANDROID"})
    @Description("Product wasn't add if decline pop up")
    @TmsLink("C10")
    public void productWasNotAddToBuyList() {
        assertFalse(mainPage.insertNameOfNewBuyList(BUY_LIST_NAME)
                .saveNewBuyList()
                .insertNameOfNewProduct(PRODUCT_NAME)
                .declineAddNewProduct()
                .openBuyListWithName(BUY_LIST_NAME)
                .isProductWithNameDisplayed(PRODUCT_NAME), "Product is displayed");
    }

    @Test(groups = {"ANDROID"})
    @Description("Delete product from created buy list")
    @TmsLink("C11")
    public void deleteProductInBuyList() {
        assertFalse(mainPage.insertNameOfNewBuyList(BUY_LIST_NAME)
                .saveNewBuyList()
                .insertNameOfNewProduct(PRODUCT_NAME)
                .confirmAddNewProduct()
                .openEditPopUp(PRODUCT_NAME)
                .removeProductOptionInPopUp()
                .confirmRemoveProduct()
                .isProductWithNameDisplayed(PRODUCT_NAME), "Product is displayed");
    }

    @Test(groups = {"ANDROID"})
    @Description("Edit information about product")
    @TmsLink("C12")
    public void editProduct() {
        mainPage.insertNameOfNewBuyList(BUY_LIST_NAME)
                .saveNewBuyList()
                .insertNameOfNewProduct(PRODUCT_NAME)
                .confirmAddNewProduct()
                .openEditPopUp(PRODUCT_NAME)
                .editProductOptionInPopUp()
                .setPriceForProduct(PRODUCT_PRICE)
                .setQuantityForProduct(PRODUCT_QUANTITY)
                .setCommentForProduct(PRODUCT_COMMENT)
                .setUnitForProduct(ProductUnit.PIECE)
                .setCategoryForProduct(ProductCategory.DAIRY_PRODUCE)
                .saveEditedProduct();
        assertTrue(buyListPage.isProductWithNameDisplayed(PRODUCT_NAME), "Product isn't displayed");
        assertTrue(buyListPage.isProductWithPriceDisplayed(PRODUCT_NAME, PRODUCT_PRICE), "Product price isn't displayed");
        assertTrue(buyListPage.isProductWithQuantityDisplayed(PRODUCT_NAME, PRODUCT_QUANTITY), "Product quantity isn't displayed");
        assertTrue(buyListPage.isProductWithCommentDisplayed(PRODUCT_NAME, PRODUCT_COMMENT), "Comment section isn't displayed");
        assertTrue(buyListPage.isProductWithUnitDisplayed(PRODUCT_NAME, ProductUnit.PIECE), "Product isn't displayed");
    }

    @AfterMethod
    public void deleteBuyList() {
        buyListPage.goToMainPage()
                .deleteBuyList(BUY_LIST_NAME);
    }
}
