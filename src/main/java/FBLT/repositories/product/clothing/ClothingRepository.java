package FBLT.repositories.product.clothing;

import FBLT.domain.product.clothing.Clothing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Clothing
 */

@RepositoryRestResource(collectionResourceRel = "clothing", path ="clothing")
public interface ClothingRepository extends MongoRepository<Clothing,String> {

    /**
     *
     * @param size The clothing size
     * @return list of clothing with that size
     *
     */
    @Query(value = "{ 'size' : ?0 }")
    List<Clothing> findbysize(@Param("size") String size);

    /**
     *
     * @param brand The clothing brand
     * @return list of clothing with that brand
     *
     */
    @Query(value = "{ 'brand' : ?0 }")
    List<Clothing> findbybrand(@Param("brand") String brand);

    /**
     *
     * @param gender The clothing gender
     * @return list of clothing with that gender
     *
     */
    @Query(value = "{ 'gender' : ?0 }")
    List<Clothing> findbygender(@Param("gender") String gender);

}
