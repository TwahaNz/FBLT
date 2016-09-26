package FBLT.repositories.register;

import FBLT.domain.register.RegisteredUserVerification;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "register", path ="register")
public interface RegisteredUserVerificationRepository extends MongoRepository<RegisteredUserVerification,String> {

}
