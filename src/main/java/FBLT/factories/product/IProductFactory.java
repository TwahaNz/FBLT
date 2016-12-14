package FBLT.factories.product;

import FBLT.domain.product.IProduct;

import java.util.Map;


/**
 * Created by lukekramer on 20/09/2016.
 */
public interface IProductFactory {

    /**
     * @param objectData A map with data about the object in it.
     * @return
     */
    IProduct getProduct(Map<String, String> objectData);
}
