package FBLT.repositories.product.livestock;

import FBLT.domain.product.livestock.Livestock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Livestock
 */

public interface LivestockRepository extends MongoRepository<Livestock,String> {

    /**
     *
     * @param grade The livestock's grade
     * @return list of livestock with that grade.
     *
     */
    @Query(value = "{ 'grade' : ?0 }")
    List<Livestock> findbygrade(String grade);

    /**
     *
     * @param age The livestock's age
     * @return list of livestock of that age.
     *
     */
    @Query(value = "{ 'age' : ?0 }")
    List<Livestock> findbyage(String age);

}
