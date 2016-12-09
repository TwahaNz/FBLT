package FBLT.domain.product.vehicle;

import FBLT.domain.product.IProduct;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public interface IVehicle extends IProduct {

    /**
     * @return returns a String with the type of vehicle example motorbike,car,boat ect...
     */

    String getVehicletype();

    /**
     * @return returns a String with the make of the vehicle
     */

    String getMake();

    /**
     * @return returns a String with the model of the vehicle
     */

    String getModel();

    /**
     * @return returns a String with the year the vehicle was made in
     */

    String getYear();

    /**
     * @return returns a String with the type of the fuel the vehicle
     */

    String getFuelType();

    /**
     * @return returns a String with the type of transmission the vehicle uses
     */

    String getTransmissionType();


}
