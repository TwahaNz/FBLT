package FBLT.factories.product;

import FBLT.domain.product.IProduct;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lukekramer on 20/09/2016.
 */
public class ProductFactoryTest {

    @Test
    public void testCategoryCreation(){

        ProductFactoryImpl factory =  ProductFactoryImpl.getInstance();

        IProduct productTest = factory.getProduct((long)3, "Cattle");

        Assert.assertNotNull(productTest);
        Assert.assertEquals("Cattle",productTest.getProductDescription());
        Assert.assertSame((long) 3, productTest.getCatagoryId());

    }
}
