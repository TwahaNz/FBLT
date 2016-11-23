package FBLT.factories.product;

import FBLT.domain.product.IProduct;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.factories.category.CategoryFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lukekramer on 20/09/2016.
 */
public class ProductFactoryTest {

    @Test
    public void testCategoryCreation(){

        CategoryFactoryImpl factory =  CategoryFactoryImpl.getInstance();

        ICategory category = factory.getCategory("Kids Toys", "Short Description");

        ProductFactoryImpl productFactory = ProductFactoryImpl.getInstance();

        IProduct product = productFactory.getProduct((Category) category,"Cattle");

        Assert.assertNotNull(product);
        Assert.assertNotNull(product.getCategory());
        Assert.assertEquals("Short Description",product.getCategory().getCategoryDescription());
        Assert.assertEquals("Kids Toys",product.getCategory().getCategoryName());
        Assert.assertEquals("Cattle",product.getDescription());


    }
}
