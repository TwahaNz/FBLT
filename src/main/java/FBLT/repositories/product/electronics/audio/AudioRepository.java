package FBLT.repositories.product.electronics.audio;

import FBLT.domain.product.electronics.audio.Audio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by lukekramer on 09/10/2016.
 */

public interface AudioRepository extends MongoRepository<Audio, String> {

    /**
     * @param make The audio's make
     * @return list of audio's of that make.
     */
    @Query(value = "{ 'make' : ?0 }")
    List<Audio> findbymake(String make);

    /**
     * @param model The audio's model
     * @return list of audio's of that model.
     */
    @Query(value = "{ 'model' : ?0 }")
    List<Audio> findbymodel(String model);

    /**
     * @param watts The audio's watts
     * @return list of audio's with that watts.
     */
    @Query(value = "{ 'watts' : ?0 }")
    List<Audio> findbywatts(String watts);

    /**
     * @param amps The audio's amps
     * @return list of audio's with that amps.
     */
    @Query(value = "{ 'amps' : ?0 }")
    List<Audio> findbyamps(String amps);
}
