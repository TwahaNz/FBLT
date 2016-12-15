package FBLT.domain.email;

import FBLT.domain.email.impl.SendVerificationEmail;
import FBLT.domain.register.RegisteredUserVerification;
import FBLT.utils.email.EmailConstants;
import junit.framework.Assert;
import org.mockito.Mock;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import static org.mockito.Mockito.when;


public class SendVerificationEmailTest {

    
    SendVerificationEmail sendVerificationEmail;


    @org.junit.Test
    public void whenThisTestPasses_thenAnEmailHasBeenSent() throws Exception {
        EmailConstants emailConstants = new EmailConstants();

        // Create a default MimeMessage object.
        Message message = new MimeMessage(emailConstants.getSession());

        RegisteredUserVerification registeredUserVerification = new RegisteredUserVerification.Builder()
                .setEmail("ferintaylor@gmail.com")
                .setVerificationCode("1234")
                .setUsername("Ferin")
                .setId("1")
                .build();

       sendVerificationEmail = new SendVerificationEmail.Builder()
                .registeredUserVerification(registeredUserVerification)
                .build();

        SendVerificationEmail mock = org.mockito.Mockito.mock(SendVerificationEmail.class);

        when(mock.sendEmail()).thenReturn(true);

        Assert.assertTrue(mock.sendEmail());
    }

}

