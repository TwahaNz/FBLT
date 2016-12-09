package FBLT.repositories.product.clothing;

import FBLT.domain.product.clothing.Clothing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Clothing
 */

public interface ClothingRepository extends MongoRepository<Clothing, String> {

    /**
     * @param size The clothing size
     * @return list of clothing with that size
     */
    @Query(value = "{ 'size' : ?0 }")
    List<Clothing> findbysize(String size);

    /**
     * @param brand The clothing brand
     * @return list of clothing with that brand
     */
    @Query(value = "{ 'brand' : ?0 }")
    List<Clothing> findbybrand(String brand);

    /**
     * @param gender The clothing gender
     * @return list of clothing with that gender
     */
    @Query(value = "{ 'gender' : ?0 }")
    List<Clothing> findbygender(String gender);

}
