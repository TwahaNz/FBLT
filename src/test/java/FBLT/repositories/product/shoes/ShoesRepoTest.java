package FBLT.repositories.product.shoes;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.shoes.IShoes;
import FBLT.domain.product.shoes.Shoes;
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
public class ShoesRepoTest {

    private static final String TAG = "ShoesTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("Shoes")
                .categoryDescription("Short Description")
                .build();

        IShoes productTest = new Shoes.Builder()
                .productDescription("Crocodile")
                .productType("Sandles")
                .productBrand("Crocs")
                .productSize("7")
                .productColor("blue")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.get_id().isEmpty());

        //RETRIEVE
        Shoes shoes = mongoOps.findById(productTest.get_id(), Shoes.class);

        Assert.assertEquals(TAG, productTest.getDescription(), shoes.getDescription());
        Assert.assertEquals(TAG, productTest.getBrand(), shoes.getBrand());
        Assert.assertEquals(TAG, productTest.getSize(), shoes.getSize());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(), shoes.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.get_id())), Update.update("type", "boot"), Shoes.class);

        shoes = mongoOps.findById(productTest.get_id(), Shoes.class);

        Assert.assertEquals(TAG, "boot", shoes.getShoeType());

        //DELETE
        mongoOps.remove(shoes);


    }
}
