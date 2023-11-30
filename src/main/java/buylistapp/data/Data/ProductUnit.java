package buylistapp.data.Data;

import lombok.Getter;

public enum ProductUnit {
    PIECE("pcs."),
    KILOGRAM("kg."),
    PACK("pack"),
    LITER("l"),
    GRAM("g"),
    BOTTLE("bottles"),
    BOX("box"),
    METER("m"),
    CENTIMETER("sm"),
    UNIT("unit"),
    PACKAGE("package"),
    COUPLE("couple"),
    TEN("ten");

    ProductUnit(String value) {
        this.value = value;
    }

    @Getter
    final String value;

    @Override
    public String toString() {
        return this.value;
    }
}
