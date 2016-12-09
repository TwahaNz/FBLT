package FBLT.domain.product.electronics.television;

import FBLT.domain.product.electronics.IElectronics;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public interface ITelevision extends IElectronics {

    /**
     * @return returns a String with the type for example smart tv or normal
     */
    String getType();

    /**
     * @return returns a String with the size of the tv
     */
    String getSize();

}
