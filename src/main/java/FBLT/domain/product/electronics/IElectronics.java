package FBLT.domain.product.electronics;

import FBLT.domain.product.IProduct;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public interface IElectronics extends IProduct {

    /**
     *
     * @return returns a String with the make of the item
     */

    String getMake();

    /**
     *
     * @return returns a String with the model of the item
     */

    String getModel();

}
