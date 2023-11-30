package com.buylistapp.tests.currency;

import buylistapp.data.Data.Currency;
import buylistapp.data.dataproviders.CurrencyDataProvider;
import com.buylistapp.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static buylistapp.data.Data.Product.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CurrencyTests extends BaseTest {

    @Test(groups = {"ANDROID"}, dataProvider = "currencyProvider",
            dataProviderClass = CurrencyDataProvider.class)
    @Description("Change currency")
    @TmsLink("C6")
    public void changeCurrency(Currency currency) {
        assertTrue(mainPage.openMenu()
                .openSettings()
                .openCurrencyPopUp()
                .chooseCurrency(currency)
                .isChosenCurrencyEqualTo(currency), "Chosen currency isn't equal to shown");
        assertEquals(settingsPage.goToMainPage()
                .createBuyList(BUY_LIST_NAME)
                .addProduct(PRODUCT_NAME, PRODUCT_PRICE)
                .getCurrencyOfBuyList(), currency.getValue(), "Currencies isn't equal");
    }

    @Test(groups = {"ANDROID"})
    @Description("Create own currency")
    @TmsLink("C7")
    public void createOwnCurrency() {
        assertEquals(mainPage.openMenu()
                .openSettings()
                .openCurrencyPopUp()
                .chooseCurrency(Currency.OTHER)
                .chooseOwnCurrency("UAH")
                .goToMainPage()
                .createBuyList(BUY_LIST_NAME)
                .addProduct(PRODUCT_NAME, PRODUCT_PRICE)
                .getCurrencyOfBuyList(), Currency.OTHER.getValue(), "Currencies isn't equal");
    }

    @AfterMethod
    public void deleteBuyList() {
        buyListPage.goToMainPage()
                .deleteBuyList(BUY_LIST_NAME);
    }
}
