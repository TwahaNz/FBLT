package FBLT.repositories.product.livestock;

import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.livestock.Livestock;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "livestock", path ="livestock")
public interface LivestockRepository extends MongoRepository<Livestock,String> {

}
