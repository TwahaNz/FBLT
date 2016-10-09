package FBLT.repositories.product.electronics.computer;

import FBLT.domain.product.electronics.computer.Computer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by lukekramer on 09/10/2016.
 */
@RepositoryRestResource(collectionResourceRel = "computer", path ="computer")
public interface ComputerRepository extends MongoRepository<Computer,String>{
}
