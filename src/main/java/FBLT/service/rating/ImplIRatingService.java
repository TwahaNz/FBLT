package FBLT.service.rating;

import FBLT.domain.rating.Rating;
import FBLT.repositories.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by student on 2016/12/12.
 */
@Service
public class ImplIRatingService implements IRatingService {

    @Autowired
    RatingRepository repository;

    @Override
    public Rating findRatingByAdvertId(String advertId) {
        return repository.findRatingByAdvertId(advertId);
    }

    @Override
    public Rating create(Rating entity) {
        return repository.save(entity);
    }

    @Override
    public Rating readById(String s) {
        return repository.findOne(s);
    }

    @Override
    public Set<Rating> readAll() {
        return null;
    }

    @Override
    public Rating update(Rating entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Rating entity) {
        repository.delete(entity);
    }
}
