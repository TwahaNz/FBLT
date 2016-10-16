package FBLT.repositories.product.vehicle;

import FBLT.domain.product.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Vehicle
 */


public interface VehicleRepository extends MongoRepository<Vehicle,String> {

}
