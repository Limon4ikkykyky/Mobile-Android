package com.buylistapp.tests;

import buylistapp.data.driver.DriverProvider;
import buylistapp.data.listeners.allure.Screenshot;
import buylistapp.data.tests.pages.base.buylist.AbstractBuyListPage;
import buylistapp.data.tests.pages.base.categories.AbstractEditCategoriesPage;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;
import buylistapp.data.tests.pages.base.mylist.AbstractMyListPage;
import buylistapp.data.tests.pages.base.settings.AbstractSettingsPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;

public class BaseTest {
    protected Logger logger = Logger.getLogger(getClass().getSimpleName());
    protected AbstractMainPage mainPage;
    protected AbstractBuyListPage buyListPage;
    protected AbstractEditCategoriesPage editCategoriesPage;
    protected AbstractSettingsPage settingsPage;
    protected AbstractMyListPage myListPage;
    Screenshot allureScreenshot = new Screenshot();

    @Step("Set up method was executed")
    @BeforeMethod(alwaysRun = true)
    @Parameters({"instance"})
    public void setUp(int instance) {
        logger.info("Set up method started");
        DriverProvider.create(instance);
        logger.info("Driver was created");
        mainPage = AbstractMainPage.getInstance();
        buyListPage = AbstractBuyListPage.getInstance();
        settingsPage = AbstractSettingsPage.getInstance();
        editCategoriesPage = AbstractEditCategoriesPage.getInstance();
        myListPage = AbstractMyListPage.getInstance();
        logger.info("Pages was created");
    }

    @Step("Tear down method was executed")
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        logger.info("Tear down was started");
        allureScreenshot.takeScreenshotWhenTestFail(testResult, DriverProvider.getDriver());
        DriverProvider.getDriver().quit();
    }

    public void assertTrueWithMessage(boolean condition, String successMessage, String errorMessage) {
        try {
            Assert.assertTrue(condition);
            System.out.print("\u001B[32m");
            System.out.println(successMessage);
            System.out.print("\u001B[0m");
        } catch (AssertionError e) {
            Assert.fail(errorMessage);
        }
    }


    public void assertFalseWithMessage(boolean condition, String successMessage, String errorMessage) {
        try {
            Assert.assertFalse(condition);
            System.out.print("\u001B[32m");
            System.out.println(successMessage);
            System.out.print("\u001B[0m");
        } catch (AssertionError e) {
            Assert.fail(errorMessage);
        }
    }

    public void assertEqualsWithMessage(Object expected, Object actual, String successMessage, String errorMessage) {
        try {
            Assert.assertEquals(expected, actual);
            System.out.print("\u001B[32m");
            System.out.println(successMessage);
            System.out.print("\u001B[0m");
        } catch (AssertionError e) {
            Assert.fail(errorMessage);
        }
    }

}
