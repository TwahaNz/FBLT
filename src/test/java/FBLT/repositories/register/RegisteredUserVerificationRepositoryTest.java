package FBLT.repositories.register;

import FBLT.domain.register.RegisteredUserVerification;
import FBLT.factories.register.RegisteredUserVerificationFactory;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description These test will be for CRUD Repository with mongodb using the RegisteredUserVerficationRespository Class
 */

public class RegisteredUserVerificationRepositoryTest {

    private static final String TAG = "RegisteredUserVerificationTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        RegisteredUserVerification verifyRegUser = RegisteredUserVerificationFactory.getRegisteredUser("John",
                "John@gmail.com", "879546");

        //INSERT
        mongoOps.insert(verifyRegUser);

        Assert.assertFalse(TAG, verifyRegUser.getId().isEmpty());

        //RETRIEVE
        RegisteredUserVerification verifyRegUserQuery = mongoOps.findById(verifyRegUser.getId(), RegisteredUserVerification.class);

        Assert.assertEquals(TAG, verifyRegUser.getEmail(), verifyRegUserQuery.getEmail());
        Assert.assertEquals(TAG, verifyRegUser.getId(), verifyRegUserQuery.getId());
        Assert.assertEquals(TAG, verifyRegUser.getUsername(), verifyRegUserQuery.getUsername());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(verifyRegUser.getId())), Update.update("username", "Peter"), RegisteredUserVerification.class);

        verifyRegUserQuery = mongoOps.findById(verifyRegUser.getId(), RegisteredUserVerification.class);

        Assert.assertEquals(TAG, "Peter", verifyRegUserQuery.getUsername());

        //DELETE
        mongoOps.remove(verifyRegUser);

    }
}
