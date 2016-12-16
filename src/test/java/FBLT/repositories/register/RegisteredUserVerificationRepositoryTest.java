package FBLT.repositories.register;

import FBLT.domain.register.RegisteredUserVerification;
import FBLT.factories.register.RegisteredUserVerificationFactory;
import FBLT.service.register.IRegisterUserVerificationService;
import FBLT.service.register.ImplRegisterUserVerificationService;
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
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description These test will be for CRUD Repository with mongodb using the RegisteredUserVerficationRespository Class
 */
@RunWith(MockitoJUnitRunner.class)
public class RegisteredUserVerificationRepositoryTest {

    @Mock
    private IRegisterUserVerificationService service;

    private RegisteredUserVerification verifyRegUser, user;

    @Before
    public void setup()
    {
        verifyRegUser = RegisteredUserVerificationFactory.getRegisteredUser("John",
                "John@gmail.com", "879546");
        user = new RegisteredUserVerification.Builder()
                .setUsername("Kyle").build();

        service = Mockito.mock(ImplRegisterUserVerificationService.class);

    }

    @Test
    public void testCRUD() {

        //Create
        when(service.create(user)).thenReturn(verifyRegUser);

        Assert.assertNotNull(service.create(user));

        //Find

        when(service.readById("1")).thenReturn(user);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getUsername(),"Kyle");

       //Update
        //Username now John

       when(service.update(user)).thenReturn(verifyRegUser);

       Assert.assertNotNull(service.update(user));

       Assert.assertEquals(service.update(user).getUsername(),"John");

       //Delete

        Assert.assertNotNull(service.create(user));

        service.delete(service.create(user));


    }


}
