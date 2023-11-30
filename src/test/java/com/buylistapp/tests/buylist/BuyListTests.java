package com.buylistapp.tests.buylist;

import com.buylistapp.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

import static buylistapp.data.Data.Product.*;
import static org.testng.Assert.*;

public class BuyListTests extends BaseTest {

    @Test(groups = {"ANDROID"})
    @Description("Create and delete new buy list")
    @TmsLink("C1")
    public void createAndDeleteNewBuyList() {
        assertTrueWithMessage(mainPage.insertNameOfNewBuyList(BUY_LIST_NAME)
                .saveNewBuyList()
                .isActualNameOfBuyListEqualsToInputted(BUY_LIST_NAME), "First Assert passed", "Actual name isn't equals to inputted");
        assertTrueWithMessage(buyListPage.goToMainPage()
                .isBuyListPresentOnScreen(BUY_LIST_NAME), "Second Assert passed", "Buy list isn't present on screen");
        assertFalseWithMessage(mainPage.deleteBuyList(BUY_LIST_NAME)
                .isBuyListPresentOnScreen(BUY_LIST_NAME), "Third Assert passed", "Buy list is present on screen");
    }

    @Test(groups = {"ANDROID"})
    @Description("Create and rename new buy list")
    @TmsLink("C2")
    public void createAndRenameNewBuyList() {
        assertTrueWithMessage(mainPage.insertNameOfNewBuyList(BUY_LIST_NAME)
                .saveNewBuyList()
                .isActualNameOfBuyListEqualsToInputted(BUY_LIST_NAME), "First Assert passed", "Actual name isn't equals to inputted");
        assertTrueWithMessage(buyListPage.goToMainPage()
                .isBuyListPresentOnScreen(BUY_LIST_NAME), "Second Assert passed", "Buy list isn't present on screen");
        assertTrueWithMessage(mainPage.changeNameOfBuyList(BUY_LIST_NAME, REVERSE_NAME_BUY_LIST)
                .isBuyListPresentOnScreen(REVERSE_NAME_BUY_LIST), "Third Assert passed", "Buy list isn't present on screen");
        assertFalseWithMessage(mainPage.deleteBuyList(REVERSE_NAME_BUY_LIST)
                .isBuyListPresentOnScreen(REVERSE_NAME_BUY_LIST), "Fourth Assert passed", "Buy list is present on screen");
    }

    @Test(groups = {"ANDROID"})
    @Description("Check sum in buy list for single product")
    @TmsLink("C3")
    public void createBuyListAndCheckSumForSingleProduct() {
        assertEqualsWithMessage(mainPage.insertNameOfNewBuyList(BUY_LIST_NAME)
                .saveNewBuyList()
                .addProduct(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QUANTITY)
                .getSumOfBuyList(), buyListPage.countSumOfProduct(PRODUCT_PRICE, PRODUCT_QUANTITY), "First Assert Passed","Wrong sum of product");
        assertFalseWithMessage(buyListPage.goToMainPage()
                .deleteBuyList(BUY_LIST_NAME)
                .isBuyListPresentOnScreen(BUY_LIST_NAME), "Second Assert passed", "Buy list is present on screen");
    }
}
