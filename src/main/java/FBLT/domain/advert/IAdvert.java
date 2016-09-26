package FBLT.domain.advert;

import FBLT.domain.product.Product;
import FBLT.domain.user.User;
import FBLT.utils.genericvalueobjects.Location;

/**
 * Created by maybra01 on 9/21/2016.
 */
public interface IAdvert {

    String getId();

    User getUser();

    Product getProduct();

    boolean isBuyOrSell();

    double getPrice();

    Location getLocation();
}