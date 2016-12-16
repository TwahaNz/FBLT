package FBLT.repositories.product.shoes;

import FBLT.domain.product.livestock.Livestock;
import FBLT.domain.product.shoes.Shoes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by lukekramer on 16/12/2016.
 */
public interface ShoeRepository extends MongoRepository<Shoes,String> {

    /**
     * @param type of shoe
     * @return list shoes.
     */
    @Query(value = "{ 'type' : ?0 }")
    List<Shoes> findbyType(String type);
}
