package FBLT.domain.product.electronics.cellphone;

import FBLT.domain.product.electronics.IElectronics;


/**
 * Created by kraluk01 on 9/21/2016.
 */
public interface ICellPhone extends IElectronics {

    /**
     * @return returns a String with the type for example smart phone or normal
     */
    String getType();

}
