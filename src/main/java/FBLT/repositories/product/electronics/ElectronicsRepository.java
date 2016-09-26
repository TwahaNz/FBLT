package FBLT.repositories.product.electronics;

import FBLT.domain.product.clothing.Clothing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "clothing", path ="clothing")
public interface ElectronicsRepository extends MongoRepository<Clothing,String> {

}
