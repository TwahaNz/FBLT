package FBLT.domain.advert;

import FBLT.utils.genericvalueobjects.Location;

/**
 * Created by maybra01 on 9/21/2016.
 */
public interface IAdvert {

    Long getAdvertID();

    Long getUserID();

    Long getProductID();

    boolean isBuyOrSell();

    double getPrice();

    Location getLocation();
}