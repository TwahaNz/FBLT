package FBLT.service.product.electronics.audio;

import FBLT.domain.product.electronics.audio.Audio;
import FBLT.service.Service;

import java.util.List;

/**
 * Created by student on 2016/11/12.
 */
public interface IAudioService extends Service<Audio, String> {

    List<Audio> findbymake(String make);

    List<Audio> findbymodel(String model);

    List<Audio> findbywatts(String watts);

    List<Audio> findbyamps(String amps);
}
