package FBLT.domain.product.shoes;

import FBLT.domain.product.IProduct;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public interface IShoes extends IProduct {

    /**
     * @return returns a String with the type of clothing item for example socks,jacket,pants ect...
     */

    String getShoeType();

    /**
     * @return returns a String with the make/branding of the Clothing
     */

    String getBrand();

    /**
     * @return returns a String with the size of the item
     */

    String getSize();

    /**
     * @return returns a String with the color of the item
     */

    String getColor();


}
