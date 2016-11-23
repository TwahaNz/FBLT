package FBLT.repositories.product.electronics.computer;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.electronics.computer.Computer;
import FBLT.domain.product.electronics.computer.IComputer;
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
public class ComputerRepoTest {

    private static final String TAG = "ComputerTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("Computer")
                .categoryDescription("Short Description")
                .build();

        IComputer productTest = new Computer.Builder()
                .productDescription("2015 model")
                .productMake("Apple")
                .productModel("Mac Book pro")
                .productType("Laptop")
                .productSize("15")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.get_id().isEmpty());

        //RETRIEVE
        Computer computer= mongoOps.findById(productTest.get_id(), Computer.class);

        Assert.assertEquals(TAG, productTest.getDescription(),computer.getDescription());
        Assert.assertEquals(TAG, productTest.getMake(),computer.getMake());
        Assert.assertEquals(TAG, productTest.getType(),computer.getType());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(),computer.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.get_id())), Update.update("type", "Desktop"), Computer.class);

        computer = mongoOps.findById(productTest.get_id(), Computer.class);

        Assert.assertEquals(TAG, "Desktop", computer.getType());

        //DELETE
        mongoOps.remove(computer);


    }
}
