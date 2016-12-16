package FBLT.repositories.user;

import FBLT.domain.user.User;
import FBLT.service.user.IUserService;
import FBLT.service.user.UserServiceImpl;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.mockito.Mockito.when;
import static org.springframework.data.mongodb.core.query.Criteria.where;


/**
 * Created by Brandonhome on 2016/10/09.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {
    @Mock
    private IUserService service;

    private User myUser,user;

    @Before
    public void setup()
    {
              myUser = new User.Builder()
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
               .id("123")
               .name("Sally")
              .build();

        user = new User.Builder()
                .name("Dave").build();

        service = Mockito.mock(UserServiceImpl.class);

    }


    @Test
    public void testUserCRUD() {

        //Create
        when(service.create(user)).thenReturn(myUser);

        Assert.assertNotNull(service.create(user));

        //Find

        when(service.readById("123")).thenReturn(user);

        Assert.assertNotNull(service.readById("123"));

        Assert.assertEquals(service.readById("123").getName(),"Dave");

        //Update

        when(service.update(user)).thenReturn(myUser);


        Assert.assertNotNull(service.update(user));


        Assert.assertEquals(service.update(user).getName(),"Sally");

        //Delete
        Assert.assertNotNull(service.create(user));

        service.delete(service.create(user));


    }
}

