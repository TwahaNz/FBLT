package FBLT.domain.product.shoes;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public class ShoesTest {

    @Test
    public void testCategoryCreation(){

        ICategory category = new Category.Builder()
                .categoryName("Shoes")
                .categoryDescription("Short Description")
                .build();

        IShoes productTest = new Shoes.Builder()
                .id("1")
                .productDescription("Crocodile")
                .productType("Sandles")
                .productBrand("Crocs")
                .productSize("7")
                .productColor("blue")
                .category((Category) category)
                .build();

        Assert.assertNotNull(productTest);
        Assert.assertEquals("Crocodile",productTest.getDescription());
        Assert.assertEquals("Sandles",productTest.getShoeType());
        Assert.assertEquals("Crocs",productTest.getBrand());
        Assert.assertEquals("7",productTest.getSize());
        Assert.assertEquals("blue",productTest.getColor());
        Assert.assertSame("1",productTest.get_id());
        Assert.assertNotNull(productTest.getCategory().getCategoryName());
        Assert.assertEquals("Shoes",productTest.getCategory().getCategoryName());
        Assert.assertEquals("Short Description",productTest.getCategory().getCategoryDescription());

    }

}
