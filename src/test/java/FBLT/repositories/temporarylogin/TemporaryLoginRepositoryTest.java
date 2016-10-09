package FBLT.repositories.temporarylogin;

import FBLT.domain.temporarylogin.TemporaryLogin;
import FBLT.domain.user.User;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by student on 2016/10/10.
 */
public class TemporaryLoginRepositoryTest {
    private static final String TAG = "Temp login RepoTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "test");

        User user = new User.Builder()
                .contactDetails(new ContactDetails.Builder()
                        .cellPhoneNumber("0810101966")
                        .emailAddress("example@gmail.com")
                        .telegramHandle("@maybmuzic")
                        .build())
                .location(new Location.Builder()
                        .city("Cape Town")
                        .latitude(new Double(14566.3))
                        .longitude(new Double(7899.3))
                        .suburb("Northern Suburbs")
                        .build())
                .id("MYDAMNID")
                .name("Sally")
                .build();


        TemporaryLogin temporaryLogin = new TemporaryLogin.Builder()
                .user(user)
                .code("123")
                .id("1")
                .build();


        //INSERT
        mongoOps.insert(temporaryLogin);

        Assert.assertFalse(TAG, temporaryLogin.getId().isEmpty());

        //RETRIEVE
        TemporaryLogin temporaryLogin1 = mongoOps.findById(temporaryLogin.getId(), TemporaryLogin.class);

        Assert.assertEquals(temporaryLogin1.getUser().getName(), "Sally");

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(temporaryLogin1.getId())), Update.update("code", "789"), TemporaryLogin.class);

        Assert.assertEquals("789", temporaryLogin1.getCode());

        //DELETE
        mongoOps.remove(temporaryLogin1);


    }
}
