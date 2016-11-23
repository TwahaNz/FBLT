package FBLT.repositories.product.vehicle;

import FBLT.domain.product.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Vehicle
 */


public interface VehicleRepository extends MongoRepository<Vehicle,String> {


    @Query(value = "{ 'type' : ?0 }")
    List<Vehicle> findbytype(String type);


    @Query(value = "{ 'make' : ?0 }")
    List<Vehicle> findbymake(String make);

    @Query(value = "{ 'model' : ?0 }")
    List<Vehicle> findbymodel(String model);


}
