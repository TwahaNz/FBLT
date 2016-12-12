package FBLT.domain.email.impl;

import FBLT.domain.email.Email;
import FBLT.domain.register.RegisteredUserVerification;
import FBLT.utils.email.EmailConstants;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* Created by student on 2016/09/24.*/


public class SendVerificationEmail implements Email {

    private RegisteredUserVerification registeredUserVerification;

    private SendVerificationEmail() {
    }

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

            String message1 = "<html><body>";
            message1 += "<form action='http://mysite.com/process.php' method='post' target='_blank'>";
            message1 += "<label>How did you like the movie <strong>Turfnuts</strong>?</label><br />";
            message1 += "<input name='rating' type='radio' /> ★☆☆☆<br />";
            message1 += "<input name='rating' type='radio' /> ★★☆☆<br />";
            message1 += "<input name='rating' type='radio' /> ★★★☆<br />";
            message1 += "<input name='rating' type='radio' /> ★★★★<br />";
            message1 += "<br />";
            message1 += "<label for='commentText'>Leave a quick review:</label><br />";
            message1 += "<textarea cols='75' name='commentText' rows='5'></textarea><br />";
            message1 += "<br />";
            message1 += "<input type='submit' value='Submit your review' />&nbsp;</form>";
            message1 += "</body></html>";

            message.setContent(message1, "text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Message sent successfully");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static class Builder {
        private RegisteredUserVerification registeredUserVerification;

        public Builder registeredUserVerification(RegisteredUserVerification registeredUserVerification) {
            this.registeredUserVerification = registeredUserVerification;
            return this;
        }

        public Builder copy(SendVerificationEmail sendVerificationEmail) {
            this.registeredUserVerification = sendVerificationEmail.registeredUserVerification;
            return this;
        }

        public SendVerificationEmail build() {
            return new SendVerificationEmail(this);
        }
    }

}
