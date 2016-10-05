package FBLT.repositories.product;

import FBLT.domain.product.book.Book;
import FBLT.domain.product.book.IBook;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.clothing.IClothing;
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
public class ClothingRepoTest {

    private static final String TAG = "ClothingTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("Clothing")
                .categoryDescription("Short Description")
                .build();

        IClothing productTest = new Clothing.Builder()
                .id("1")
                .productDescription("Coach Jacket")
                .productType("Jacket")
                .productBrand("Sol Sol")
                .productGender("male")
                .productAgeGroup("Adult")
                .productSize("medium")
                .productColor("blue")
                .productMaterial("nylon")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.getId().isEmpty());

        //RETRIEVE
        Clothing clothing= mongoOps.findById(productTest.getId(), Clothing.class);

        Assert.assertEquals(TAG, productTest.getProductDescription(),clothing.getProductDescription());
        Assert.assertEquals(TAG, productTest.getBrand(),clothing.getBrand());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(),clothing.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.getId())), Update.update("color", "red"), Clothing.class);

        clothing = mongoOps.findById(productTest.getId(), Clothing.class);

        Assert.assertEquals(TAG, "red", clothing.getColor());

        //DELETE
        mongoOps.remove(clothing);


    }


}
