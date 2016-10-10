package FBLT.repositories.product.electronics.audio;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.audio.Audio;
import FBLT.domain.product.electronics.audio.IAudio;
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
public class AudioRepoTest {

    private static final String TAG = "AudioTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("Audio")
                .categoryDescription("Short Description")
                .build();

        IAudio productTest = new Audio.Builder()
                .productDescription("2015 model")
                .productMake("Apple")
                .productModel("Beats")
                .productType("headphones")
                .productWatts("")
                .productAmps("")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.get_id().isEmpty());

        //RETRIEVE
        Audio audio= mongoOps.findById(productTest.get_id(), Audio.class);

        Assert.assertEquals(TAG, productTest.getDescription(),audio.getDescription());
        Assert.assertEquals(TAG, productTest.getMake(),audio.getMake());
        Assert.assertEquals(TAG, productTest.getType(),audio.getType());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(),audio.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.get_id())), Update.update("type", "speakers"), Audio.class);

        audio = mongoOps.findById(productTest.get_id(), Audio.class);

        Assert.assertEquals(TAG, "speakers", audio.getType());

        //DELETE
        mongoOps.remove(audio);


    }
}
