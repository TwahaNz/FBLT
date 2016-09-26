package FBLT.repositories.product.livestock;

import FBLT.domain.product.livestock.Livestock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Livestock
 */

@RepositoryRestResource(collectionResourceRel = "livestock", path ="livestock")
public interface LivestockRepository extends MongoRepository<Livestock,String> {

}
