package FBLT.repositories.product.electronics.television;

import FBLT.domain.product.electronics.television.Television;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by lukekramer on 09/10/2016.
 */
@RepositoryRestResource(collectionResourceRel = "television", path ="television")
public interface TelevisionRepository extends MongoRepository<Television,String>{
}
