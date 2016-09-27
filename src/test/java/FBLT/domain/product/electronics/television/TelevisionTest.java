package FBLT.domain.product.electronics.television;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.cellphone.CellPhone;
import FBLT.domain.product.electronics.cellphone.ICellPhone;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public class TelevisionTest {

    @Test
    public void testCategoryCreation(){

        ICategory category = new Category.Builder()
                .categoryName("Television")
                .categoryDescription("Short Description")
                .build();

        ITelevision productTest = new Television.Builder()
                .id("1")
                .productDescription("2015 model")
                .productMake("Samsung")
                .productModel("UA40J5200AKXXA")
                .productType("Smart Led Tv")
                .productSize("40")
                .category((Category) category)
                .build();

        Assert.assertNotNull(productTest);
        Assert.assertEquals("2015 model",productTest.getProductDescription());
        Assert.assertEquals("Samsung",productTest.getMake());
        Assert.assertEquals("UA40J5200AKXXA",productTest.getModel());
        Assert.assertEquals("Smart Led Tv",productTest.getType());
        Assert.assertEquals("40",productTest.getSize());
        Assert.assertSame("1",productTest.getId());
        Assert.assertNotNull(productTest.getCategory().getCategoryName());
        Assert.assertEquals("Television",productTest.getCategory().getCategoryName());
        Assert.assertEquals("Short Description",productTest.getCategory().getCategoryDescription());

    }

}
