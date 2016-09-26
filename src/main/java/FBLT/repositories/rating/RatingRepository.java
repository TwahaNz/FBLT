package FBLT.repositories.rating;

import FBLT.domain.rating.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Rating
 */

@RepositoryRestResource(collectionResourceRel = "rating", path ="rating")
public interface RatingRepository extends MongoRepository<Rating,String> {

}
