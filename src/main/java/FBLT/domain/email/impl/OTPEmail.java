package FBLT.domain.email.impl;

import FBLT.domain.email.Email;
import FBLT.domain.temporarylogin.TemporaryLogin;
import FBLT.utils.Constants;
import FBLT.utils.email.EmailConstants;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by tayfer01 on 11/22/2016.
 */
public class OTPEmail implements Email {

    private TemporaryLogin temporaryLogin;


    public OTPEmail(Builder builder){
        this.temporaryLogin = temporaryLogin;
    }

    private OTPEmail(){}

    public TemporaryLogin getTemporaryLogin() {
        return temporaryLogin;
    }

    @Override
    public boolean sendEmail() {
        try {
            EmailConstants emailConstants = new EmailConstants();

            // Create a default MimeMessage object.
            Message message = new MimeMessage(emailConstants.getSession());

            message.setFrom(new InternetAddress(emailConstants.getFrom()));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(temporaryLogin.getUser().getContactDetails().getEmailAddress()));

            message.setSubject("do-not-reply");

            message.setText("Please follow this link to login: " + Constants.PROTOCOL + "://" + Constants.URL + ":" + Constants.PORT
                    + "/login?email="
                    + temporaryLogin.getUser().getContactDetails().getEmailAddress()
                    + "&code="
                    + temporaryLogin.getCode());


            Transport.send(message);

            System.out.println("Message sent successfully");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static class Builder{

        private TemporaryLogin temporaryLogin;

        public Builder temporaryLogin(TemporaryLogin temporaryLogin){
            this.temporaryLogin = temporaryLogin;
            return this;
        }

        public Builder copy(OTPEmail otpEmail){
            this.temporaryLogin = otpEmail.temporaryLogin;
            return this;
        }

        public OTPEmail build(){
            return new OTPEmail(this);
        }

    }

}
