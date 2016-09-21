package FBLT.domain.product;

/**
 * Created by lukekramer on 20/09/2016.
 */
public interface IProduct {

    /**
     *
     * @return returns a products id
     */

    Long getProductId();

    /**
     *
     * @return returns a catagories id
     */

    Long getCatagoryId();


    /**
     *
     * @return returns a String describing the product
     */
    String getProductDescription();


}
