package FBLT.repositories.product.electronics.cellphone;

import FBLT.domain.product.electronics.cellphone.CellPhone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by lukekramer on 09/10/2016.
 */
@RepositoryRestResource(collectionResourceRel = "cellphone", path ="cellphone")
public interface CellPhoneRepository extends MongoRepository<CellPhone,String> {

    /**
     *
     * @param make The cellphone's make
     * @return list of cellphone's of that make.
     *
     */
    @Query(value = "{ 'make' : ?0 }")
    List<CellPhone> findbymake(@Param("make") String make);

    /**
     *
     * @param model The cellphone's model
     * @return list of cellphone's of that model.
     *
     */
    @Query(value = "{ 'model' : ?0 }")
    List<CellPhone> findbymodel(@Param("model") String model);
}
