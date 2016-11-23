package FBLT.domain.product.livestock;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kraluk01 on 9/21/2016.
 */
public class LivestockTest {

    @Test
    public void testCategoryCreation(){

        ICategory category = new Category.Builder()
                .categoryName("LiveStock")
                .categoryDescription("Short Description")
                .build();

        ILivestock productTest = new Livestock.Builder()
                .id("1")
                .productDescription("Cow")
                .productAge("4")
                .productGrade("A")
                .category((Category) category)
                .build();

        Assert.assertNotNull(productTest);
        Assert.assertEquals("Cow",productTest.getDescription());
        Assert.assertEquals("4",productTest.getAge());
        Assert.assertEquals("A",productTest.getGrade());
        Assert.assertSame("1",productTest.get_id());
        Assert.assertNotNull(productTest.getCategory().getCategoryName());
        Assert.assertEquals("LiveStock",productTest.getCategory().getCategoryName());
        Assert.assertEquals("Short Description",productTest.getCategory().getCategoryDescription());

    }
}
