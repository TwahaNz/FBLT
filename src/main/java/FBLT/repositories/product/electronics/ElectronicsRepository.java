package FBLT.repositories.product.electronics;

import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.electronics.audio.Audio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Electronics
 */

@RepositoryRestResource(collectionResourceRel = "clothing", path ="clothing")
public interface ElectronicsRepository extends MongoRepository<Clothing,String> {


}
