package FBLT.domain.product.electronics.audio;

import FBLT.domain.product.electronics.IElectronics;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public interface IAudio extends IElectronics {


    /**
     * @return returns a String with the type for example headphones or stereo
     */
    String getType();

    /**
     * @return returns a String with the watts
     */
    String getWatts();

    /**
     * @return returns a String with the size of the amps
     */
    String getAmps();


}
