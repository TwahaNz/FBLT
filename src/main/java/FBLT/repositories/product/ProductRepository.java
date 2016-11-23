package FBLT.repositories.product;

import FBLT.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Product
 */

@RepositoryRestResource(collectionResourceRel = "product", path ="product")
public interface ProductRepository extends MongoRepository<Product,String> {

}
