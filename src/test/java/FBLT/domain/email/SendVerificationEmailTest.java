package FBLT.domain.email;

import FBLT.domain.email.impl.SendVerificationEmail;
import FBLT.domain.register.RegisteredUserVerification;
import junit.framework.Assert;

/**
 * Created by student on 2016/09/25.
 */

public class SendVerificationEmailTest {

    @org.junit.Test
    public void whenThisTestPasses_thenAnEmailHasBeenSent() throws Exception {

        RegisteredUserVerification registeredUserVerification = new RegisteredUserVerification.Builder()
                .setEmail("ferintaylor@gmail.com")
                .setVerificationCode("1234")
                .setUsername("Ferin")
                .setId(new Long(1))
                .build();

        SendVerificationEmail sendVerificationEmail = new SendVerificationEmail.Builder()
                .registeredUserVerification(registeredUserVerification)
                .build();

        Assert.assertTrue(sendVerificationEmail.sendEmail());
    }

}
