package FBLT.domain;

import FBLT.domain.category.Category;
import FBLT.domain.category.ICategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Brandonhome on 2016/09/20.
 */

public class CategoryTest {

    @Test
    public void testCategoryCreation(){
        ICategory myTestCategory = new Category.Builder()
                .categoryName("Kids Toys")
                .categoryDescription("Short Description")
                .build();

        Assert.assertNotNull(myTestCategory);
        Assert.assertEquals("Short Description",myTestCategory.getCategoryDescription());
        Assert.assertEquals("Kids Toys",myTestCategory.getCategoryName());

    }

}
