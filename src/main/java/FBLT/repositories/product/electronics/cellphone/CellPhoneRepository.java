package FBLT.repositories.product.electronics.cellphone;

import FBLT.domain.product.electronics.cellphone.CellPhone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by lukekramer on 09/10/2016.
 */

public interface CellPhoneRepository extends MongoRepository<CellPhone, String> {

    /**
     * @param make The cellphone's make
     * @return list of cellphone's of that make.
     */
    @Query(value = "{ 'make' : ?0 }")
    List<CellPhone> findbymake(String make);

    /**
     * @param model The cellphone's model
     * @return list of cellphone's of that model.
     */
    @Query(value = "{ 'model' : ?0 }")
    List<CellPhone> findbymodel(String model);
}
