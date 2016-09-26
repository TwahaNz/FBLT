package FBLT.domain.repositories;

import FBLT.domain.advert.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Brandonhome on 2016/09/26.
 */
public interface AdvertRepository extends MongoRepository<Advert, String> {
}
