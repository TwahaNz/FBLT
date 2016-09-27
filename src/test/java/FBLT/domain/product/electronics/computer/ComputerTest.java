package FBLT.domain.product.electronics.computer;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public class ComputerTest {

    @Test
    public void testCategoryCreation(){

        ICategory category = new Category.Builder()
                .categoryName("Computer")
                .categoryDescription("Short Description")
                .build();

        IComputer productTest = new Computer.Builder()
                .id("1")
                .productDescription("2015 model")
                .productMake("Apple")
                .productModel("Mac Book pro")
                .productType("Laptop")
                .productSize("15")
                .category((Category) category)
                .build();

        Assert.assertNotNull(productTest);
        Assert.assertEquals("2015 model",productTest.getProductDescription());
        Assert.assertEquals("Apple",productTest.getMake());
        Assert.assertEquals("Mac Book pro",productTest.getModel());
        Assert.assertEquals("Laptop",productTest.getType());
        Assert.assertEquals("15",productTest.getSize());
        Assert.assertSame("1",productTest.getId());
        Assert.assertNotNull(productTest.getCategory().getCategoryName());
        Assert.assertEquals("Computer",productTest.getCategory().getCategoryName());
        Assert.assertEquals("Short Description",productTest.getCategory().getCategoryDescription());

    }

}
