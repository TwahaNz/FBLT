package FBLT.domain.repositories.advert;

import FBLT.domain.advert.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Brandonhome on 2016/09/26.
 */
@RepositoryRestResource(collectionResourceRel = "advert", path ="advert")
public interface AdvertRepository extends MongoRepository<Advert, String> {

}
