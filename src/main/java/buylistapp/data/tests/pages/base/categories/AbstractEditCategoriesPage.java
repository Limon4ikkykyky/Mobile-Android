package buylistapp.data.tests.pages.base.categories;

import buylistapp.data.Data.ProductCategory;
import buylistapp.data.tests.elements.categories.EditCategoriesPageElements;
import buylistapp.data.tests.pages.android.categories.EditCategoriesPageAndroid;
import buylistapp.data.tests.pages.base.main.AbstractMainPage;

public abstract class AbstractEditCategoriesPage extends EditCategoriesPageElements {

    public static AbstractEditCategoriesPage getInstance() {
        return  new EditCategoriesPageAndroid();
    }

    public AbstractEditCategoriesPage addCategory(ProductCategory productCategory) {
        return this;
    }

    public AbstractMainPage goToMainPage() {
        return AbstractMainPage.getInstance();
    }

    public boolean isCategoryDisplayed(ProductCategory productCategory) {
        return false;
    }

    public AbstractEditCategoriesPage deleteCategory(ProductCategory productCategory) {return this;}
}
