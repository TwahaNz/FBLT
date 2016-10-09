package FBLT.repositories.temporarylogin;

import FBLT.domain.temporarylogin.TemporaryLogin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by student on 2016/10/10.
 */
@RepositoryRestResource(collectionResourceRel = "temporarylogin", path = "temporarylogin")
public interface TemporaryLoginRepository extends MongoRepository<TemporaryLogin, String> {

    // still need to add a query to select where user = user and code = code
}
