package FBLT.repositories.product.vehicle;

import FBLT.domain.product.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "vehicle", path ="vehicle")
public interface VehicleRepository extends MongoRepository<Vehicle,String> {

}
