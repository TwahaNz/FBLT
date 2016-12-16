package FBLT.repositories.temporarylogin;

import FBLT.domain.temporarylogin.TemporaryLogin;
import FBLT.domain.user.User;
import FBLT.service.temporarylogin.ITemporaryLoginService;
import FBLT.service.temporarylogin.ImplITemporaryLoginService;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;



/**
 * Created by student on 2016/10/10.
 */
@RunWith(MockitoJUnitRunner.class)
public class TemporaryLoginRepositoryTest {
    @Mock
    private ITemporaryLoginService service;

    private TemporaryLogin temporaryLogin,login;

    @Before
    public void setup() {

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


         temporaryLogin = new TemporaryLogin.Builder()
                .user(user)
                .code("123")
                .id("1")
                .build();


         login = new TemporaryLogin.Builder()
                 .id("1")
                 .code("456")
                 .build();

        service = Mockito.mock(ImplITemporaryLoginService.class);

    }

    @Test
    public void testCRUD() {

        //Create
        when(service.create(login)).thenReturn(temporaryLogin);

        Assert.assertNotNull(service.create(login));

        //Find

        when(service.readById("1")).thenReturn(login);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getId(),"1");

        //Update

        when(service.update(login)).thenReturn(temporaryLogin);

        Assert.assertNotNull(service.update(login));

        Assert.assertNotEquals(service.update(login).getCode(),"123");

        //Delete

        Assert.assertNotNull(service.create(login));

        service.delete(service.create(login));

    }
}

