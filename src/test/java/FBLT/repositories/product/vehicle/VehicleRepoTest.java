package FBLT.repositories.product.vehicle;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.vehicle.IVehicle;
import FBLT.domain.product.vehicle.Vehicle;
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
public class VehicleRepoTest {

    private static final String TAG = "VehicleTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        ICategory category = new Category.Builder()
                .categoryName("Vehicle")
                .categoryDescription("Short Description")
                .build();

        IVehicle productTest = new Vehicle.Builder()
                .productDescription("Sports Car")
                .productType("Car")
                .productMake("BMW")
                .productModel("M3")
                .productYear("2016")
                .productFuel("Petrol")
                .productTransmission("Manual")
                .category((Category) category)
                .build();

        //INSERT
        mongoOps.insert(productTest);

        Assert.assertFalse(TAG, productTest.get_id().isEmpty());

        //RETRIEVE
        Vehicle vehicle= mongoOps.findById(productTest.get_id(), Vehicle.class);

        Assert.assertEquals(TAG, productTest.getDescription(),vehicle.getDescription());
        Assert.assertEquals(TAG, productTest.getMake(),vehicle.getMake());
        Assert.assertEquals(TAG, productTest.getYear(),vehicle.getYear());
        Assert.assertEquals(TAG, productTest.getCategory().getCategoryName(),vehicle.getCategory().getCategoryName());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(productTest.get_id())), Update.update("model", "M5"), Vehicle.class);

        vehicle = mongoOps.findById(productTest.get_id(), Vehicle.class);

        Assert.assertEquals(TAG, "M5", vehicle.getModel());

        //DELETE
        mongoOps.remove(vehicle);


    }
}
