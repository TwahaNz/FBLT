package FBLT.domain.product.electronics.cellphone;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kraluk01 on 9/21/2016.
 */
public class CellPhoneTest {
    @Test
    public void testCategoryCreation(){

        ICategory category = new Category.Builder()
                .categoryName("CellPhone")
                .categoryDescription("Short Description")
                .build();

        ICellPhone productTest = new CellPhone.Builder()
                .productID((long) 1)
                .productDescription("2015 model")
                .productMake("Iphone")
                .productModel("S6")
                .productType("SmartPhone")
                .category((Category) category)
                .build();

        Assert.assertNotNull(productTest);
        Assert.assertEquals("2015 model",productTest.getProductDescription());
        Assert.assertEquals("Iphone",productTest.getMake());
        Assert.assertEquals("S6",productTest.getModel());
        Assert.assertEquals("SmartPhone",productTest.getType());
        Assert.assertSame((long)1,productTest.getId());
        Assert.assertNotNull(productTest.getCategory().getCategoryName());
        Assert.assertEquals("CellPhone",productTest.getCategory().getCategoryName());
        Assert.assertEquals("Short Description",productTest.getCategory().getCategoryDescription());

    }


}
