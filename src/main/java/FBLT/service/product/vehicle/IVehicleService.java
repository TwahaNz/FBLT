package FBLT.service.product.vehicle;

import FBLT.domain.product.vehicle.Vehicle;
import FBLT.service.Service;

import java.util.List;

/**
 * Created by lukekramer on 16/10/2016.
 */
public interface IVehicleService extends Service<Vehicle, String> {


    List<Vehicle> findbytype(String type);


    List<Vehicle> findbymake(String make);


    List<Vehicle> findbymodel(String model);


}
