package FBLT.factories.product;

import FBLT.domain.product.Product;



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

    public Product getProduct(Long catagoryId, String description) {

        return new Product.Builder()
                .productDescription(description)
                .categoryID(catagoryId)
                .build();
    }
}
