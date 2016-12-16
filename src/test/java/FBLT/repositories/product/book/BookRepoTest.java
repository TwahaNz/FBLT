package FBLT.repositories.product.book;

import FBLT.domain.product.book.Book;
import FBLT.domain.product.book.IBook;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.service.product.book.IBookService;
import FBLT.service.product.book.ImplIBookService;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.mockito.Mockito.when;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by lukekramer.
 */
@RunWith(MockitoJUnitRunner.class)
public class BookRepoTest {
    @Mock
    private IBookService service;

    private Book productTest,product;

    @Before
    public void setup(){

        ICategory category = new Category.Builder()
                .categoryName("Book")
                .categoryDescription("Short Description")
                .build();

        productTest = new Book.Builder()
                .productDescription("Fairy Tale")
                .productAuthor("Ferin")
                .productTitle("Snow White")
                .productISBN("945-2497659111")
                .productGenre("Fantasy")
                .category((Category) category)
                .build();
        product = new Book.Builder()
                .productAuthor("Tom")
                .build();

        service = Mockito.mock(ImplIBookService.class);

    }

    @Test
    public void testCRUD() {

        //Create
        when(service.create(product)).thenReturn(productTest);

        Assert.assertNotNull(service.create(product));

        //Find

        when(service.readById("1")).thenReturn(product);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getAuthor(),"Tom");

        //Update

        //Author Updated

        when(service.update(product)).thenReturn(productTest);

        Assert.assertNotNull(service.update(product));

        Assert.assertEquals(service.update(product).getAuthor(),"Ferin");

        //Delete

        Assert.assertNotNull(service.create(product));

        service.delete(service.create(product));

    }


}
