package FBLT.repositories.rating;

import FBLT.domain.rating.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Rating
 */


public interface RatingRepository extends MongoRepository<Rating, String> {

    @Query(value = "{ 'advertID' : ?0 }")
    Rating findRatingByAdvertId(String advertId);

    // finds the average rating for user
    @Query(value = "{ 'userID' : ?0 }")
    List<Rating> findRatingByUserId(String userId);

}
