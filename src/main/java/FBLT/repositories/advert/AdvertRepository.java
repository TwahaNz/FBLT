package FBLT.repositories.advert;

import FBLT.domain.advert.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Advert
 */

@RepositoryRestResource(collectionResourceRel = "advert", path ="advert")
public interface AdvertRepository extends MongoRepository<Advert, String> {

}
