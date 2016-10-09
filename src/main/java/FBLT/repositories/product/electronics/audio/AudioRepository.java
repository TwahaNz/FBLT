package FBLT.repositories.product.electronics.audio;

import FBLT.domain.product.electronics.audio.Audio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by lukekramer on 09/10/2016.
 */
@RepositoryRestResource(collectionResourceRel = "audio", path ="audio")
public interface AudioRepository extends MongoRepository<Audio,String> {
}
