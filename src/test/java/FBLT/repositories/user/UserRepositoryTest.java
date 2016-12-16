package FBLT.repositories.user;

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
 * Created by Brandonhome on 2016/10/09.
 */

public class UserRepositoryTest {
    private static final String TAG = "UserRepoTest: ";

    @Test
    public void testUserCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "FBLT");

        User myUser = new User.Builder()
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
        //INSERT
        mongoOps.insert(myUser);

        Assert.assertFalse(TAG, myUser.get_id().isEmpty());

        //RETRIEVE
        User retrievedUser = mongoOps.findById(myUser.get_id(), User.class);

        Assert.assertEquals(TAG, retrievedUser.getName(), myUser.getName());
        Assert.assertEquals(TAG, retrievedUser.getContactDetails().getTelegramHandle(), myUser.getContactDetails().getTelegramHandle());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(retrievedUser.get_id())), Update.update("contactDetails.emailAddress", "changedmailaddress@gmail.com"), User.class);

        try {
            Thread.sleep(50000);
        } catch (Exception ex) {

        }

        Assert.assertEquals("changedmailaddress@gmail.com", retrievedUser.getContactDetails().getEmailAddress());

        //DELETE
        mongoOps.remove(retrievedUser);


    }
}

