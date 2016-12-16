package FBLT.repositories.product.vehicle;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.product.vehicle.IVehicle;
import FBLT.domain.product.vehicle.Vehicle;
import FBLT.service.product.vehicle.IVehicleService;
import FBLT.service.product.vehicle.ImplVehicleService;
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
 * Created by lukekramer on 09/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class VehicleRepoTest {

    @Mock
    private IVehicleService service;

    private Vehicle productTest,product;

    @Before
    public void setup(){

        ICategory category = new Category.Builder()
                .categoryName("Vehicle")
                .categoryDescription("Short Description")
                .build();

        productTest = new Vehicle.Builder()
                .id("1")
                .productDescription("Sports Car")
                .productType("Car")
                .productMake("BMW")
                .productModel("M3")
                .productYear("2016")
                .productFuel("Petrol")
                .productTransmission("Manual")
                .category((Category) category)
                .build();
        product = new Vehicle.Builder().
                productMake("Fiat").build();

        service = Mockito.mock(ImplVehicleService.class);

    }

    @Test
    public void testCRUD() {

        //Create
        when(service.create(product)).thenReturn(productTest);

        Assert.assertNotNull(service.create(product));

        //Find

        when(service.readById("1")).thenReturn(productTest);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getMake(),"BMW");

        //Update

        //Make from fiat to bmw

        when(service.update(product)).thenReturn(productTest);

        Assert.assertNotNull(service.update(product));

        Assert.assertEquals(service.update(product).getMake(),"BMW");

        //Delete

        Assert.assertNotNull(service.create(product));

        service.delete(service.create(product));

    }
}
