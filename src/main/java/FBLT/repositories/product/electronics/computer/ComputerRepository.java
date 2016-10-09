package FBLT.repositories.product.electronics.computer;

import FBLT.domain.product.electronics.computer.Computer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by lukekramer on 09/10/2016.
 */
@RepositoryRestResource(collectionResourceRel = "computer", path ="computer")
public interface ComputerRepository extends MongoRepository<Computer,String>{

    /**
     *
     * @param make The computer's make
     * @return list of computer's of that make.
     *
     */
    @Query(value = "{ 'make' : ?0 }")
    List<Computer> findbymake(@Param("make") String make);

    /**
     *
     * @param model The computer's model
     * @return list of computer's of that model.
     *
     */
    @Query(value = "{ 'model' : ?0 }")
    List<Computer> findbymodel(@Param("model") String model);

}
