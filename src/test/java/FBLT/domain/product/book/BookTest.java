package FBLT.domain.product.book;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public class BookTest {


    @Test
    public void testCategoryCreation(){

        ICategory category = new Category.Builder()
                .categoryName("Book")
                .categoryDescription("Short Description")
                .build();

        IBook productTest = new Book.Builder()
                .id("1")
                .productDescription("Fairy Tale")
                .productAuthor("Ferin Taylor")
                .productTitle("Snow White")
                .productISBN("945-2497659111")
                .productGenre("Fantasy")
                .category((Category) category)
                .build();

        Assert.assertNotNull(productTest);
        Assert.assertEquals("Fairy Tale",productTest.getProductDescription());
        Assert.assertEquals("Snow White",productTest.getTitle());
        Assert.assertEquals("Ferin Taylor",productTest.getAuthor());
        Assert.assertEquals("945-2497659111",productTest.getISBN());
        Assert.assertEquals("Fantasy",productTest.getGenre());
        Assert.assertSame("1",productTest.getId());
        Assert.assertNotNull(productTest.getCategory().getCategoryName());
        Assert.assertEquals("Book",productTest.getCategory().getCategoryName());
        Assert.assertEquals("Short Description",productTest.getCategory().getCategoryDescription());

    }

}
