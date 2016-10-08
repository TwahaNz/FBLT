package FBLT.repositories.advert;

import FBLT.domain.advert.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Advert
 */

@RepositoryRestResource(collectionResourceRel = "advert", path ="advert")
public interface AdvertRepository extends MongoRepository<Advert, String> {

    @Query(value = "{ 'user.name' : ?0 }")
    List<Advert> find(@Param("username") String username);

    @Query(value = "{ 'user._id' : ?0 }")
    List<Advert> findByUserID(@Param("userid") String userId);

}
