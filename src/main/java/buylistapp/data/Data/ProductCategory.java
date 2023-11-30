package buylistapp.data.Data;

import lombok.Getter;
import lombok.Setter;

public enum ProductCategory {

    NO_CATEGORY("No category"),
    DAIRY_PRODUCE("Dairy produce"),
    PET_PRODUCTS("Pet products"),
    ACCESSORIES_GROCERY("Accessories Grocery"),
    CHILD_PRODUCTS("Child products"),
    MEDICATIONS("Medications"),
    STATIONERY("Stationery"),
    COSMETICS_HYGIENE("Cosmetics, hygiene"),
    SPORTING_GOODS_GAMES("Sporting goods, games"),
    ORNAMENTATION("Ornamentation"),
    ACCESSORIES("Accessories"),
    CLOTHING_FOOTWEAR("Clothing, footwear"),
    FRUITS_VEGETABLES("Fruits, vegetables, pickles"),
    AUTO_PRODUCTS("Auto products"),
    HOUSEHOLD_APPLIANCES("Household appliances"),
    PLANTS("Plants"),
    MEAT_FISH_EGGS("Meat, fish, eggs"),
    FROZEN_FOOD("Frozen food"),
    DRINKS_JUICES("Drinks, juices"),
    BREAD_CAKES_PASTRIES("Bread, cakes and pastries"),
    CONFECTION("Confection"),
    GROCERY("Grocery"),
    ALCOHOL_TOBACCO("Alcohol, tobacco"),
    NEW_CATEGORY("");



    ProductCategory(String value) {
        this.value = value;
    }

    @Getter
    @Setter
    String value;

    @Override
    public String toString() {
        return this.value;
    }
}
