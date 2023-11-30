package buylistapp.data.tests.pages.android.buylist;

import buylistapp.data.Data.ProductCategory;
import buylistapp.data.Data.ProductUnit;
import buylistapp.data.tests.pages.base.buylist.AbstractBuyListPage;
import buylistapp.data.tests.pages.base.main.AbstractGoToMainPage;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;
import buylistapp.data.tests.pages.base.mylist.AbstractMyListPage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

import java.text.DecimalFormat;

public class BuyListPageAndroid extends AbstractBuyListPage {

    @Override
    @Step("Get actual name of buy list")
    public boolean isActualNameOfBuyListEqualsToInputted(String buyListName) {
        return automator.findByTextContainsWithScroll(buyListName).isDisplayed();
    }

    @Override
    @Step("Back to the main page")
    public AbstractMainPage goToMainPage() {
        return AbstractGoToMainPage.getInstance().go();
    }

    @Override
    @Step("Insert name of new product {0}")
    public AbstractBuyListPage insertNameOfNewProduct(String productName) {
        logger.info("Insert name of new product " + productName);
        fieldAddProduct.sendKeys(productName);
        return this;
    }

    @Override
    @Step("Confirm add new product in buy list")
    public AbstractBuyListPage confirmAddNewProduct() {
        logger.info("Confirm add new product in buy list");
        buttonAddProduct.click();
        return this;
    }

    @Override
    @Step("Is product with name {0} displayed")
    public boolean isProductWithNameDisplayed(String nameProduct) {
        logger.info("Is product with name " + nameProduct + " displayed");
        return automator.isDisplayedByText(nameProduct);
    }

    @Override
    @Step("Decline save new product")
    public AbstractMainPage declineAddNewProduct() {
        logger.info("Decline save new product");
        boolean isSavePopUp = false;
        while (!isSavePopUp) {
            try {
                isSavePopUp = saveItemPopUp.isDisplayed();
            } catch (NoSuchElementException exception) {
                pressKey.androidPressBack();
            }
        }
        buttonNoSaveProduct.click();
        return AbstractMainPage.getInstance();
    }

    @Override
    @Step("Open edit pop up by long press")
    public AbstractBuyListPage openEditPopUp(String productName) {
        pressKey.longPressOnElement(automator.findByTextContainsWithScroll(productName));
        return this;
    }

    @Override
    @Step("Remove chosen product")
    public AbstractBuyListPage removeProductOptionInPopUp() {
        buttonRemoveProduct.click();
        return this;
    }

    @Override
    @Step("Confirm that product will be delete")
    public AbstractBuyListPage confirmRemoveProduct() {
        buttonYesInAlertConfirm.click();
        return this;
    }

    @Override
    @Step("Edit product")
    public AbstractBuyListPage editProductOptionInPopUp() {
        buttonEditProduct.click();
        return this;
    }

    @Override
    @Step("Set price {0} for product")
    public AbstractBuyListPage setPriceForProduct(String productPrice) {
        priceField.sendKeys(productPrice);
        return this;
    }

    @Override
    @Step("Set quantity {0} for product")
    public AbstractBuyListPage setQuantityForProduct(String productQuantity) {
        quantityField.sendKeys(productQuantity);
        return this;
    }

    @Override
    @Step("Set quantity {0} for product")
    public AbstractBuyListPage setQuantityForProduct(Integer productQuantity) {
        quantityField.sendKeys(String.valueOf(productQuantity));
        return this;
    }

    @Override
    @Step("Set comment {0} for product")
    public AbstractBuyListPage setCommentForProduct(String productComment) {
        commentField.sendKeys(productComment);
        return this;
    }

    @Override
    @Step("Set unit for product")
    public AbstractBuyListPage setUnitForProduct(ProductUnit productUnit) {
        unitSpinner.click();
        automator.findByTextContainsWithScroll(productUnit.getValue()).click();
        return this;
    }

    @Override
    @Step("Set category for product")
    public AbstractBuyListPage setCategoryForProduct(ProductCategory productCategory) {
        categorySpinner.click();
        automator.findByTextContainsWithScroll(productCategory.getValue()).click();
        return this;
    }

    @Override
    @Step("Save edited product")
    public AbstractBuyListPage saveEditedProduct() {
        buttonAddProduct.click();
        return this;
    }

    @Override
    @Step("Is product {0} with price {1} displayed on screen")
    public boolean isProductWithPriceDisplayed(String productName, String productPrice) {
        return wait.whenClickableAndFindByNextElements(productName, 3)
                .getText()
                .contains(productPrice);
    }

    @Override
    @Step("Is product {0} with quantity {1} displayed on screen")
    public boolean isProductWithQuantityDisplayed(String productName, String productQuantity) {
        return wait.whenClickable(xPath.findNextElementsByText(productName, 2))
                .getText()
                .contains(productQuantity);
    }

    @Override
    @Step("Is product {0} with comment {1} displayed on screen")
    public boolean isProductWithCommentDisplayed(String productName, String productComment) {
        return wait.whenClickable(xPath.findNextElementsByText(productName, 1))
                .getText()
                .contains(productComment);
    }

    @Override
    @Step("Is product {0} with unit {1} displayed on screen")
    public boolean isProductWithUnitDisplayed(String productName, ProductUnit productUnit) {
        return wait.whenClickable(xPath.findNextElementsByText(productName, 2))
                .getText()
                .contains(productUnit.getValue());
    }

    @Override
    @Step("Get sum of buy list")
    public Double getSumOfBuyList() {
        pressKey.hideKeyboardSafe();
        return Double.parseDouble(totalSumOfBuyList.getText().replaceAll("[^\\d.]", ""));
    }

    @Override
    @Step("Add product {0} with price {1} and quantity {2}")
    public AbstractBuyListPage addProduct(String productName, String productPrice, String productQuantity) {
        return AbstractBuyListPage.getInstance()
                .insertNameOfNewProduct(productName)
                .setPriceForProduct(productPrice)
                .setQuantityForProduct(productQuantity)
                .confirmAddNewProduct();
    }

    @Override
    @Step("Add product {0}")
    public AbstractBuyListPage addProduct(String productName) {
        return AbstractBuyListPage.getInstance()
                .insertNameOfNewProduct(productName)
                .confirmAddNewProduct();
    }

    @Override
    @Step("Add product {0} with price {1}")
    public AbstractBuyListPage addProduct(String productName, String productPrice) {
        return AbstractBuyListPage.getInstance()
                .insertNameOfNewProduct(productName)
                .setPriceForProduct(productPrice)
                .confirmAddNewProduct();
    }

    @Override
    @Step("Count sum of product with price {0} and quantity {1}")
    public Double countSumOfProduct(String productPrice, String productQuantity) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(Double.parseDouble(productPrice) * Double.parseDouble(productQuantity)));
    }

    @Override
    @Step("Get currency of buy list")
    public String getCurrencyOfBuyList() {
        pressKey.hideKeyboardSafe();
        return totalSumOfBuyList.getText()
                .replace("Total: ", "")
                .replaceAll("\\d", "")
                .replaceAll("[.]", "")
                .replaceAll(" ", "");
    }

    @Override
    @Step("Check is category {0} is displayed in category list")
    public boolean isCategoryDisplayedInList(ProductCategory category) {
        categorySpinner.click();
        boolean isCategoryDisplayed = automator.isDisplayedByTextWithScroll(category.getValue());
        pressKey.androidPressBack();
        return isCategoryDisplayed;
    }

    @Override
    @Step("Clean field of name for product")
    public AbstractBuyListPage cleanFieldNameProduct() {
        fieldAddProduct.clear();
        return this;
    }

    @Override
    @Step("Add new product with name {0}, price - {1} and category {2}")
    public AbstractBuyListPage addProduct(String productName, String productPrice, ProductCategory productCategory) {
        return AbstractBuyListPage.getInstance()
                .insertNameOfNewProduct(productName)
                .setPriceForProduct(productPrice)
                .setCategoryForProduct(productCategory)
                .confirmAddNewProduct();
    }

    @Override
    @Step("Open menu")
    public AbstractBuyListPage openMenu() {
        buttonMenu.click();
        return this;
    }

    @Override
    @Step("Open add from My List")
    public AbstractMyListPage openAddFromMyList() {
        buttonAddFromMyList.click();
        return AbstractMyListPage.getInstance();
    }

    @Override
    @Step("Delete product with name {0}")
    public AbstractBuyListPage deleteProduct(String productName) {
        return openEditPopUp(productName)
                .removeProductOptionInPopUp();
    }
}

