package FBLT.factories.product.vehicle;

import FBLT.domain.product.vehicle.Vehicle;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public interface IVehicleFactory {

    Vehicle getVehicle(Map<String, String> details);
}
