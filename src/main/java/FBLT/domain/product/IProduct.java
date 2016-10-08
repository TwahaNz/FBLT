package FBLT.domain.product;

import FBLT.domain.product.category.Category;

/**
 * Created by lukekramer on 20/09/2016.
 */
public interface IProduct {

    /**
     *
     * @return returns a products id
     */

    String getId();

    /**
     *
     * @return returns an object of the Category class
     */

     Category getCategory();


    /**
     *
     * @return returns a String describing the product
     */
    String getDescription();


}
