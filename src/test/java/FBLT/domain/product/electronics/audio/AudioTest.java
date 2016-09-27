package FBLT.domain.product.electronics.audio;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.television.ITelevision;
import FBLT.domain.product.electronics.television.Television;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public class AudioTest {

    @Test
    public void testCategoryCreation(){

        ICategory category = new Category.Builder()
                .categoryName("Audio")
                .categoryDescription("Short Description")
                .build();

        IAudio productTest = new Audio.Builder()
                .id("1")
                .productDescription("2015 model")
                .productMake("Apple")
                .productModel("Beats")
                .productType("headphones")
                .productWatts("")
                .productAmps("")
                .category((Category) category)
                .build();

        Assert.assertNotNull(productTest);
        Assert.assertEquals("2015 model",productTest.getProductDescription());
        Assert.assertEquals("Apple",productTest.getMake());
        Assert.assertEquals("Beats",productTest.getModel());
        Assert.assertEquals("headphones",productTest.getType());
        Assert.assertEquals("",productTest.getWatts());
        Assert.assertEquals("",productTest.getAmps());
        Assert.assertSame("1",productTest.getId());
        Assert.assertNotNull(productTest.getCategory().getCategoryName());
        Assert.assertEquals("Audio",productTest.getCategory().getCategoryName());
        Assert.assertEquals("Short Description",productTest.getCategory().getCategoryDescription());

    }

}
