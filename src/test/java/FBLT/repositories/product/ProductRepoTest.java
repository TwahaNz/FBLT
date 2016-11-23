package FBLT.repositories.product;

import FBLT.domain.product.IProduct;
import FBLT.domain.product.Product;
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
 * Created by lukekramer on 09/10/2016.
 */
public class ProductRepoTest {

    private static final String TAG = "ProductTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("Kids Toys")
                .categoryDescription("Short Description")
                .build();

        IProduct productTest = new Product.Builder()
                .productDescription("swing")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.get_id().isEmpty());

        //RETRIEVE
        Product product= mongoOps.findById(productTest.get_id(), Product.class);

        Assert.assertEquals(TAG, productTest.getDescription(),product.getDescription());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryDescription(),product.getCategory().getCategoryDescription());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(),product.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.get_id())), Update.update("description", "scooter"), Product.class);

        product = mongoOps.findById(productTest.get_id(), Product.class);

        Assert.assertEquals(TAG, "scooter", product.getDescription());

        //DELETE
        mongoOps.remove(product);


    }
}
