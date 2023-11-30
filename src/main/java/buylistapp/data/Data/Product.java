package buylistapp.data.Data;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Product {
    private static final Random random = new Random();
    public static final String BUY_LIST_NAME = "List " + random.nextInt(1000);
    public static final String REVERSE_NAME_BUY_LIST = new StringBuilder().append(BUY_LIST_NAME).reverse().toString();
    public static final String PRODUCT_NAME = "Product " + random.nextInt(1000);
    public static final String PRODUCT_PRICE = String.format("%.2f", nextDoubleBetween(1, 100));
    public static final String PRODUCT_QUANTITY = String.valueOf(random.nextInt(10));
    public static final String PRODUCT_COMMENT = "Comment " + random.nextInt(10);
    public static final String CATEGORY_NAME = "Category " + + random.nextInt(1000);

    private static double nextDoubleBetween(double min, double max) {
        return (ThreadLocalRandom.current().nextDouble() * (max - min)) + min;
    }
}
