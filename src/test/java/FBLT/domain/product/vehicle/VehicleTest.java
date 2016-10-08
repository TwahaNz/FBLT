package FBLT.domain.product.vehicle;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public class VehicleTest {

    @Test
    public void testCategoryCreation(){

        ICategory category = new Category.Builder()
                .categoryName("Vehicle")
                .categoryDescription("Short Description")
                .build();

        IVehicle productTest = new Vehicle.Builder()
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

        Assert.assertNotNull(productTest);
        Assert.assertEquals("Sports Car",productTest.getDescription());
        Assert.assertEquals("Car",productTest.getVehicletype());
        Assert.assertEquals("BMW",productTest.getMake());
        Assert.assertEquals("M3",productTest.getModel());
        Assert.assertEquals("2016",productTest.getYear());
        Assert.assertEquals("Petrol",productTest.getFuelType());
        Assert.assertEquals("Manual",productTest.getTransmissionType());
        Assert.assertSame("1",productTest.getId());
        Assert.assertNotNull(productTest.getCategory().getCategoryName());
        Assert.assertEquals("Vehicle",productTest.getCategory().getCategoryName());
        Assert.assertEquals("Short Description",productTest.getCategory().getCategoryDescription());

    }
}
