package FBLT.factories.product;

import FBLT.domain.product.category.Category;
import FBLT.domain.product.Product;


/**
 * Created by lukekramer on 20/09/2016.
 */
public interface IProductFactory {


    Product getProduct(Category catagory, String description);
}
