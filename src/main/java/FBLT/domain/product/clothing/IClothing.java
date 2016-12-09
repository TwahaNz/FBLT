package FBLT.domain.product.clothing;

import FBLT.domain.product.IProduct;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public interface IClothing extends IProduct {

    /**
     * @return returns a String with the type of clothing item for example socks,jacket,pants ect...
     */

    String getClothingType();

    /**
     * @return returns a String with the make/branding of the Clothing
     */

    String getBrand();

    /**
     * @return returns a String with the gender of the intendend customer
     */

    String getGender();

    /**
     * @return returns a String with age of the intended
     */

    String getAge();

    /**
     * @return returns a String with the size of the item
     */

    String getSize();

    /**
     * @return returns a String with the color of the item
     */

    String getColor();

    /**
     * @return returns a String with the material the item is made of
     */

    String getMaterial();


}
