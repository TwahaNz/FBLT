package FBLT.repositories.product.book;

import FBLT.domain.product.book.Book;
import FBLT.domain.product.book.IBook;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;

import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by lukekramer.
 */
public class BookRepoTest {

    private static final String TAG = "BookTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("Book")
                .categoryDescription("Short Description")
                .build();

        IBook productTest = new Book.Builder()
                .productDescription("Fairy Tale")
                .productAuthor("Ferin Taylor")
                .productTitle("Snow White")
                .productISBN("945-2497659111")
                .productGenre("Fantasy")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.getId().isEmpty());

        //RETRIEVE
        Book book= mongoOps.findById(productTest.getId(), Book.class);

        Assert.assertEquals(TAG, productTest.getDescription(),book.getDescription());
        Assert.assertEquals(TAG, productTest.getAuthor(),book.getAuthor());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(),book.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.getId())), Update.update("title", "Harry Potter"), Book.class);

        book = mongoOps.findById(productTest.getId(), Book.class);

        Assert.assertEquals(TAG, "Harry Potter", book.getTitle());

        //DELETE
        mongoOps.remove(book);


    }


}
