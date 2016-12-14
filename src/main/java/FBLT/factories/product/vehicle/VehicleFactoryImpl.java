package FBLT.factories.product.vehicle;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.vehicle.Vehicle;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public class VehicleFactoryImpl implements IVehicleFactory {

    private static VehicleFactoryImpl factory = null;

    private VehicleFactoryImpl() {

    }

    public static VehicleFactoryImpl getInstance() {
        if (factory == null)
            factory = new VehicleFactoryImpl();

        return factory;
    }


    @Override
    public Vehicle getVehicle(Map<String, String> details) {
        Vehicle finalProduct = new Vehicle.Builder().build();

        if (details.containsKey("make")) {
            Vehicle VehicleWithMake = new Vehicle.Builder()
                    .copy(finalProduct)
                    .productMake(details.get("make"))
                    .build();
            finalProduct = VehicleWithMake;

        }
        if (details.containsKey("model")) {
            Vehicle VehicleWithModel = new Vehicle.Builder()
                    .copy(finalProduct)
                    .productModel(details.get("model"))
                    .build();
            finalProduct = VehicleWithModel;
        }
        if (details.containsKey("type")) {
            Vehicle VehicleWithType = new Vehicle.Builder()
                    .copy(finalProduct)
                    .productType(details.get("type"))
                    .build();
            finalProduct = VehicleWithType;
        }
        if (details.containsKey("year")) {
            Vehicle VehicleWithWatts = new Vehicle.Builder()
                    .copy(finalProduct)
                    .productYear(details.get("year"))
                    .build();
            finalProduct = VehicleWithWatts;
        }

        if (details.containsKey("fuel-type")) {
            Vehicle VehicleWithWatts = new Vehicle.Builder()
                    .copy(finalProduct)
                    .productFuel(details.get("fuel-type"))
                    .build();
            finalProduct = VehicleWithWatts;
        }
        if (details.containsKey("transmission")) {
            Vehicle VehicleWithWatts = new Vehicle.Builder()
                    .copy(finalProduct)
                    .productTransmission(details.get("transmission"))
                    .build();
            finalProduct = VehicleWithWatts;
        }
        if (details.containsKey("category")) {
            Vehicle bookWithAuthor = new Vehicle.Builder()
                    .copy(finalProduct)
                    .category(new Category.Builder().categoryName(details.get("category")).build())
                    .build();
            finalProduct = bookWithAuthor;
        }
        if (details.containsKey("ad-description")) {
            Vehicle bookWithAuthor = new Vehicle.Builder()
                    .copy(finalProduct)
                    .productDescription(details.get("ad-description"))
                    .build();
            finalProduct = bookWithAuthor;
        }

        return finalProduct;
    }
}
