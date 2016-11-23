package FBLT.domain.product.electronics.computer;

import FBLT.domain.product.electronics.IElectronics;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public interface IComputer extends IElectronics {

    /**
     *
     * @return returns a String with the type for example laptop or desktop
     */
    String getType();

    /**
     *
     * @return returns a String with the size of the computer
     */
    String getSize();
}
