package FBLT.domain.product;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lukekramer on 20/09/2016.
 */
public class ProductTest {

    @Test
    public void testCategoryCreation(){
        IProduct productTest = new Product.Builder()
                .productID((long) 1)
                .productDescription("Cattle")
                .categoryID((long) 3)
                .build();

        Assert.assertNotNull(productTest);
        Assert.assertEquals("Cattle",productTest.getProductDescription());
        Assert.assertSame((long)1,productTest.getProductId());
        Assert.assertSame((long)3,productTest.getCatagoryId());


    }
}
