package FBLT.factories.register;

import FBLT.domain.register.RegisteredUserVerification;
import FBLT.factories.register.RegisteredUserVerificationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nzetwa01 on 9/21/2016.
 */

/**
 *
 * @author Twaha Nzeyimana
 * @date 21 Septemeber 2016
 * @description Verifies if the user has been registered
 */

public class RegisteredUserVerificationFactoryTest {

    private RegisteredUserVerification registeredUserVerification;
    private String TAG = "RegisteredUserVerification: ";

    @Before
    public void setup() throws Exception {

        registeredUserVerification = RegisteredUserVerificationFactory.getRegisteredUser(
                12, "Peter", "12345", "456789");

    }

    @Test
    public void whenTheUserRegisters_checkAllTheirDetails() {
        Assert.assertEquals(TAG, 12, registeredUserVerification.getId());
        Assert.assertEquals(TAG, "Peter", registeredUserVerification.getUsername());
        Assert.assertEquals(TAG, "12345", registeredUserVerification.getEmail());
        Assert.assertEquals(TAG, "456789", registeredUserVerification.getVerificationCode());
    }
}
