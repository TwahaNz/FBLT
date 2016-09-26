package FBLT.repositories.rating;

import FBLT.domain.rating.Comment;
import FBLT.domain.rating.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "rating", path ="rating")
public interface RatingRepository extends MongoRepository<Rating,String> {

}
