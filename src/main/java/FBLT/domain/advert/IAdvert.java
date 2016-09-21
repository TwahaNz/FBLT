package FBLT.domain.advert;

/**
 * Created by maybra01 on 9/21/2016.
 */
public interface IAdvert {

    Long getAdvertID();

    Long getUserID();

    Long getProductID();

    boolean isBuyOrSell();

    double getPrice();
}