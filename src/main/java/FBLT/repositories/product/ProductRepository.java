package FBLT.repositories.product;

import FBLT.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "product", path ="product")
public interface ProductRepository extends MongoRepository<Product,String> {

}
