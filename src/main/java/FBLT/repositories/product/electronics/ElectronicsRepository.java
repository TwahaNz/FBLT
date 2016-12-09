package FBLT.repositories.product.electronics;

import FBLT.domain.product.clothing.Clothing;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Electronics
 */


public interface ElectronicsRepository extends MongoRepository<Clothing, String> {


}
