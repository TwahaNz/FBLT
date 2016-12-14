package FBLT.repositories.product.electronics.television;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.television.ITelevision;
import FBLT.domain.product.electronics.television.Television;
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
public class TelevisionRepoTest {

    private static final String TAG = "TelevisionTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("Television")
                .categoryDescription("Short Description")
                .build();

        ITelevision productTest = new Television.Builder()
                .productDescription("2015 model")
                .productMake("Samsung")
                .productModel("UA40J5200AKXXA")
                .productType("Smart Led Tv")
                .productSize("40-inch")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.get_id().isEmpty());

        //RETRIEVE
        Television television = mongoOps.findById(productTest.get_id(), Television.class);

        Assert.assertEquals(TAG, productTest.getDescription(), television.getDescription());
        Assert.assertEquals(TAG, productTest.getMake(), television.getMake());
        Assert.assertEquals(TAG, productTest.getSize(), television.getSize());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(), television.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.get_id())), Update.update("size", "70-inch"), Television.class);

        television = mongoOps.findById(productTest.get_id(), Television.class);

        Assert.assertEquals(TAG, "70-inch", television.getSize());

        //DELETE
        mongoOps.remove(television);


    }
}
