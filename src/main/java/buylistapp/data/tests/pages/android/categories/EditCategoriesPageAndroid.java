package buylistapp.data.tests.pages.android.categories;

import buylistapp.data.Data.ProductCategory;
import buylistapp.data.tests.pages.base.categories.AbstractEditCategoriesPage;
import buylistapp.data.tests.pages.base.main.AbstractGoToMainPage;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;
import io.qameta.allure.Step;

public class EditCategoriesPageAndroid extends AbstractEditCategoriesPage {

    @Override
    @Step("Add new category with name {0}")
    public AbstractEditCategoriesPage addCategory(ProductCategory productCategory) {
        buttonAddNewCategory.click();
        if (textEnterNameOfNewCategory.isDisplayed()) {
            wait.whenClickableAndSendKeys(fieldEnterNameOfCategory, productCategory.getValue());
        }
        buttonOk.click();
        return this;
    }

    @Override
    @Step("Go to main page from edit categories page")
    public AbstractMainPage goToMainPage() {
        return AbstractGoToMainPage.getInstance().go();
    }

    @Override
    @Step("Is category {0} displayed on screen")
    public boolean isCategoryDisplayed(ProductCategory productCategory) {
        return automator.isDisplayedByTextWithScroll(productCategory.getValue());
    }

    @Override
    @Step("Delete category {0}")
    public AbstractEditCategoriesPage deleteCategory(ProductCategory productCategory) {
        pressKey.longPressOnElement(automator.findByTextContainsWithScroll(productCategory.getValue()));
        buttonRemove.click();
        return this;
    }
}
