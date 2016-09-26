package FBLT.repositories.product.clothing;

import FBLT.domain.product.clothing.Clothing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Clothing
 */

@RepositoryRestResource(collectionResourceRel = "clothing", path ="clothing")
public interface ClothingRepository extends MongoRepository<Clothing,String> {

}
