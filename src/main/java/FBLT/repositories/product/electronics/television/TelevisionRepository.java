package FBLT.repositories.product.electronics.television;

import FBLT.domain.product.electronics.television.Television;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by lukekramer on 09/10/2016.
 */
@RepositoryRestResource(collectionResourceRel = "television", path = "television")
public interface TelevisionRepository extends MongoRepository<Television, String> {

    /**
     * @param make The television's make
     * @return list of television's of that make.
     */
    @Query(value = "{ 'make' : ?0 }")
    List<Television> findbymake(String make);

    /**
     * @param model The television's model
     * @return list of television's of that model.
     */
    @Query(value = "{ 'model' : ?0 }")
    List<Television> findbymodel(String model);

    /**
     * @param size The television's size
     * @return list of television's of that size.
     */
    @Query(value = "{ 'size' : ?0 }")
    List<Television> findbysize(String size);

}
