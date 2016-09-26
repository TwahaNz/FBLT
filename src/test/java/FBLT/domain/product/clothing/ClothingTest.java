package FBLT.domain.product.clothing;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public class ClothingTest {

    @Test
    public void testCategoryCreation(){

        ICategory category = new Category.Builder()
                .categoryName("Clothing")
                .categoryDescription("Short Description")
                .build();

        IClothing productTest = new Clothing.Builder()
                .id("1")
                .productDescription("Coach Jacket")
                .productType("Jacket")
                .productBrand("Sol Sol")
                .productGender("male")
                .productAgeGroup("Adult")
                .productSize("medium")
                .productColor("blue")
                .productMaterial("nylon")
                .category((Category) category)
                .build();

        Assert.assertNotNull(productTest);
        Assert.assertEquals("Coach Jacket",productTest.getProductDescription());
        Assert.assertEquals("Jacket",productTest.getClothingType());
        Assert.assertEquals("Sol Sol",productTest.getBrand());
        Assert.assertEquals("male",productTest.getGender());
        Assert.assertEquals("Adult",productTest.getAge());
        Assert.assertEquals("medium",productTest.getSize());
        Assert.assertEquals("blue",productTest.getColor());
        Assert.assertEquals("nylon",productTest.getMaterial());
        Assert.assertSame((long)1,productTest.getId());
        Assert.assertNotNull(productTest.getCategory().getCategoryName());
        Assert.assertEquals("Clothing",productTest.getCategory().getCategoryName());
        Assert.assertEquals("Short Description",productTest.getCategory().getCategoryDescription());

    }
}
