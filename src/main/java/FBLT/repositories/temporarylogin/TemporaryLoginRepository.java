package FBLT.repositories.temporarylogin;

import FBLT.domain.temporarylogin.TemporaryLogin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by student on 2016/10/10.
 */

public interface TemporaryLoginRepository extends MongoRepository<TemporaryLogin, String> {

    @Query(value = "{ 'user.contactDetails.emailAddress' : ?0, 'code' : ?1 }")
    TemporaryLogin isValidUser(String email, String code);
}
