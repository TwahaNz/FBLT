package FBLT.repositories.product.electronics.cellphone;

import FBLT.domain.product.electronics.cellphone.CellPhone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by lukekramer on 09/10/2016.
 */
@RepositoryRestResource(collectionResourceRel = "cellphone", path ="cellphone")
public interface CellPhoneRepository extends MongoRepository<CellPhone,String> {
}
