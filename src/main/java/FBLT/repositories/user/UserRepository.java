package FBLT.repositories.user;

import FBLT.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Brandonhome on 2016/10/09.
 */

public interface UserRepository extends MongoRepository<User, String> {

    @Query(value = "{ '_id' : ?0 }")
    List<User> findByUserID(String userId);

}
