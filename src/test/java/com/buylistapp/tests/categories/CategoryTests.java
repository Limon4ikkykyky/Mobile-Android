package com.buylistapp.tests.categories;

import buylistapp.data.Data.ProductCategory;
import com.buylistapp.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static buylistapp.data.Data.Product.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
public class CategoryTests extends BaseTest {
    @BeforeMethod
    public void setValueToNewCategory() {
        ProductCategory.NEW_CATEGORY.setValue(CATEGORY_NAME);
    }

    @Test(groups = {"ANDROID"})
    @Description("Create new category")
    @TmsLink("C4")
    public void createAndDeleteCategory() {
        assertTrue(mainPage.openMenu()
                .openSettings()
                .openEditCategories()
                .addCategory(ProductCategory.NEW_CATEGORY)
                .isCategoryDisplayed(ProductCategory.NEW_CATEGORY), "Category isn't present on screen");
        assertTrue(editCategoriesPage.goToMainPage()
                .createBuyList(BUY_LIST_NAME)
                .insertNameOfNewProduct(PRODUCT_NAME)
                .isCategoryDisplayedInList(ProductCategory.NEW_CATEGORY), "Category isn't present in list");
        assertFalse(buyListPage.cleanFieldNameProduct()
                .goToMainPage()
                .openMenu()
                .openSettings()
                .openEditCategories()
                .deleteCategory(ProductCategory.NEW_CATEGORY)
                .isCategoryDisplayed(ProductCategory.NEW_CATEGORY), "New category present on screen");
        assertFalse(editCategoriesPage.goToMainPage()
                .openBuyListWithName(BUY_LIST_NAME)
                .insertNameOfNewProduct(PRODUCT_NAME)
                .isCategoryDisplayedInList(ProductCategory.NEW_CATEGORY), "Category present in list");
    }

    @Test(groups = {"ANDROID"})
    @Description("Set new category to product")
    @TmsLink("C5")
    public void setNewCategoryToProduct() {
        assertTrue(mainPage.openMenu()
                .openSettings()
                .openEditCategories()
                .addCategory(ProductCategory.NEW_CATEGORY)
                .goToMainPage()
                .createBuyList(BUY_LIST_NAME)
                .insertNameOfNewProduct(PRODUCT_NAME)
                .setCategoryForProduct(ProductCategory.NEW_CATEGORY)
                .confirmAddNewProduct()
                .openEditPopUp(PRODUCT_NAME)
                .editProductOptionInPopUp()
                .isCategoryDisplayedInList(ProductCategory.NEW_CATEGORY), "Category isn't present in list");
    }

    @AfterMethod
    public void cleanUp() {
        buyListPage.goToMainPage()
                .deleteBuyList(BUY_LIST_NAME);
    }
}
