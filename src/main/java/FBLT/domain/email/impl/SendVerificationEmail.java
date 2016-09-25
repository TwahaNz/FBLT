package FBLT.domain.email.impl;

import FBLT.domain.email.Email;
import FBLT.domain.register.RegisteredUserVerification;
import FBLT.utils.email.EmailConstants;


import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by student on 2016/09/24.
 */
public class SendVerificationEmail implements Email {

    private RegisteredUserVerification registeredUserVerification;

    private SendVerificationEmail(){}

    public SendVerificationEmail(Builder builder) {
        this.registeredUserVerification = builder.registeredUserVerification;
    }

    // strictly for testing purposes
    public RegisteredUserVerification getRegisteredUserVerification() {
        return registeredUserVerification;
    }


    @Override
    public boolean sendEmail() {
        try {
            EmailConstants emailConstants = new EmailConstants();

            // Create a default MimeMessage object.
            Message message = new MimeMessage(emailConstants.getSession());

            message.setFrom(new InternetAddress(emailConstants.getFrom()));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(registeredUserVerification.getEmail()));

            message.setSubject("do-not-reply");

            message.setText("Hello " + registeredUserVerification.getUsername() + " welcome to Bubby-King! \n" +
                    "Please complete registration by entering in this registration code: " +
                    registeredUserVerification.getVerificationCode() + "\n\n\nRegards\nDev Team");


            Transport.send(message);

            System.out.println("Message sent successfully");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static class Builder
    {
        private RegisteredUserVerification registeredUserVerification;

        public Builder registeredUserVerification(RegisteredUserVerification registeredUserVerification) {
            this.registeredUserVerification = registeredUserVerification;
            return this;
        }

        public Builder copy(SendVerificationEmail sendVerificationEmail){
            this.registeredUserVerification = sendVerificationEmail.registeredUserVerification;
            return this;
        }

        public SendVerificationEmail build() {
            return new SendVerificationEmail(this);
        }
    }

}
