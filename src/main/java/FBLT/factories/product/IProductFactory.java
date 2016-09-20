package FBLT.factories.product;

import FBLT.domain.product.Product;


/**
 * Created by lukekramer on 20/09/2016.
 */
public interface IProductFactory {


    Product getProduct(Long catagoryId, String description);
}
