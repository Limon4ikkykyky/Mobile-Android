package buylistapp.data.dataproviders;

import buylistapp.data.Data.Currency;
import org.testng.annotations.DataProvider;

public class CurrencyDataProvider {
    @DataProvider(name = "currencyProvider")
    public static Object[][] getCurrencyProvider() {
        return new Object[][] {
                {Currency.DOLLAR},
                {Currency.POUND},
                {Currency.EURO},
        };
    }
}
