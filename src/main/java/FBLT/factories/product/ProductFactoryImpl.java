package FBLT.factories.product;

import FBLT.domain.product.Product;
import FBLT.domain.product.category.Category;


/**
 * Created by lukekramer on 20/09/2016.
 */
public class ProductFactoryImpl implements IProductFactory {


    private static ProductFactoryImpl factory = null;

    private ProductFactoryImpl()
    {

    }
    public static ProductFactoryImpl getInstance() {
        if (factory == null)
            factory = new ProductFactoryImpl();

        return factory;
    }

    public Product getProduct(Category category, String description) {

        return new Product.Builder()
                .productDescription(description)
                .category(category)
                .build();
    }
}
