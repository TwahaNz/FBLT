package FBLT.repositories.advert;

import FBLT.domain.advert.Advert;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by maybra01 on 10/12/2016.
 */

public interface AdvertDAO extends MongoRepository<Advert, String> {

}
