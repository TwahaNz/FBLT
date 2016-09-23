package FBLT.domain.product.cellphone;

import FBLT.domain.product.IProduct;

/**
 * Created by kraluk01 on 9/21/2016.
 */
public interface ICellPhone extends IProduct {

    /**
     *
     * @return returns a String with the make of the phone
     */

    String getMake();

    /**
     *
     * @return returns a String with the model of the phone
     */

    String getModel();



}
