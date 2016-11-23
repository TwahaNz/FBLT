package FBLT.domain.register;

import FBLT.factories.register.RegisteredUserVerificationFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by nzetwa01 on 9/21/2016.
 */
public class RegisteredUserVerificationTest {

    private RegisteredUserVerification registeredUserVerification;
    private String TAG = "RegisteredUserVerification: ";

    @Before
    public void setup() throws Exception {

        registeredUserVerification = new RegisteredUserVerification.Builder()
                .setId("12")
                .setUsername("Peter")
                .setEmail("12345")
                .setVerificationCode("456789")
                .build();

    }

    @Test
    public void whenTheUserRegisters_checkAllTheirDetails() {
        Assert.assertEquals(TAG, "12", registeredUserVerification.getId());
        Assert.assertEquals(TAG, "Peter", registeredUserVerification.getUsername());
        Assert.assertEquals(TAG, "12345", registeredUserVerification.getEmail());
        Assert.assertEquals(TAG, "456789", registeredUserVerification.getVerificationCode());
    }
}
