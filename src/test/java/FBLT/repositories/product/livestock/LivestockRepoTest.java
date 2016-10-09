package FBLT.repositories.product.livestock;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.livestock.ILivestock;
import FBLT.domain.product.livestock.Livestock;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by lukekramer on 05/10/2016.
 */
public class LivestockRepoTest {

    private static final String TAG = "LiveStockTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("LiveStock")
                .categoryDescription("Short Description")
                .build();

        ILivestock productTest = new Livestock.Builder()
                .productDescription("Cow")
                .productAge("4")
                .productGrade("A")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.getId().isEmpty());

        //RETRIEVE
        Livestock livestock= mongoOps.findById(productTest.getId(), Livestock.class);

        Assert.assertEquals(TAG, productTest.getDescription(),livestock.getDescription());
        Assert.assertEquals(TAG, productTest.getAge(),livestock.getAge());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(),livestock.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.getId())), Update.update("grade", "B"), Livestock.class);

        livestock = mongoOps.findById(productTest.getId(), Livestock.class);

        Assert.assertEquals(TAG, "B", livestock.getGrade());

        //DELETE
        mongoOps.remove(livestock);


    }
}
