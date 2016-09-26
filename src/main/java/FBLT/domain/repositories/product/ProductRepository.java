package FBLT.domain.repositories.product;

import FBLT.domain.product.Product;
import FBLT.domain.product.clothing.Clothing;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "product", path ="product")
public interface ProductRepository extends MongoRepository<Productt,String> {

}
