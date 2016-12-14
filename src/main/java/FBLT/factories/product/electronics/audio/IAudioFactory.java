package FBLT.factories.product.electronics.audio;

import FBLT.domain.product.electronics.audio.Audio;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public interface IAudioFactory {

    Audio getAudio(Map<String, String> details);
}
