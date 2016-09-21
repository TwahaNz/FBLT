package FBLT.factories.product.category;

import FBLT.domain.product.category.ICategory;
import FBLT.factories.product.category.CategoryFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Brandonhome on 2016/09/20.
 */
public class CategoryFactoryTest {
    @Test
    public void testCategoryCreation(){

        CategoryFactoryImpl factory =  CategoryFactoryImpl.getInstance();

        ICategory myTestCategory = factory.getCategory("Kids Toys", "Short Description");

        Assert.assertNotNull(myTestCategory);
        Assert.assertEquals("Short Description",myTestCategory.getCategoryDescription());
        Assert.assertEquals("Kids Toys",myTestCategory.getCategoryName());

    }
}
