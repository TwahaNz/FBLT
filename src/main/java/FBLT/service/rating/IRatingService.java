package FBLT.service.rating;

import FBLT.domain.rating.Rating;
import FBLT.service.Service;

/**
 * Created by student on 2016/12/12.
 */
public interface IRatingService extends Service<Rating, String> {
    Rating findRatingByAdvertId(String advertId);
}
