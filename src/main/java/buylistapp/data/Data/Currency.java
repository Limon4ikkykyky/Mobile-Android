package buylistapp.data.Data;

import lombok.Getter;
import lombok.Setter;

public enum Currency {

    DOLLAR("$"),
    EURO("€"),
    POUND("£"),
    OTHER("Other");

    Currency(String value) {
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
