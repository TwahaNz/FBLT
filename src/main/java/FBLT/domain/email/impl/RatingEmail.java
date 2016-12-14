package FBLT.domain.email.impl;

import FBLT.domain.advert.Advert;
import FBLT.domain.email.Email;
import FBLT.domain.rating.Rating;
import FBLT.utils.email.EmailConstants;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by student on 2016/12/12.
 */
public class RatingEmail implements Email {

    private Rating rating;
    private String buyerEmail;
    private Advert advert;

    public RatingEmail(Rating rating, String buyerEmail, Advert advert) {
        this.rating = rating;
        this.buyerEmail = buyerEmail;
        this.advert = advert;
    }

    @Override
    public boolean sendEmail() {
        try {
            EmailConstants emailConstants = new EmailConstants();

            // Create a default MimeMessage object.
            Message message = new MimeMessage(emailConstants.getSession());

            message.setFrom(new InternetAddress(emailConstants.getFrom()));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(buyerEmail));

            message.setSubject("do-not-reply");

            String message1 = "<html><body>";
            message1 += "<form action='http://localhost:8080/rate-user' method='post' >";
            message1 += "<label>Rate your buying experience with the following advert</label><br />";

            message1 += "<input type='hidden' disabled value='" + advert.getId() + "' name='advertId' />";
            message1 += "<input type='hidden' disabled value='" + rating.getUserIDBuyer() + "' name='userBuyerId'/>";
            message1 += "<input type='hidden' disabled value='" + rating.getUserID() + "' name='userSellerId'/>";

            message1 += "<p> Description <input type='text' disabled value='" + advert.getProduct().getDescription() + "'/> </p>";
            message1 += "<p> Price R <input type='text' disabled value='" + advert.getPrice() + "' /> </p>";
            message1 += "<input id='1' name='rate' type='radio' /> ★☆☆☆<br />";
            message1 += "<input id='2' name='rate' type='radio' /> ★★☆☆<br />";
            message1 += "<input id='3' name='rate' type='radio' /> ★★★☆<br />";
            message1 += "<input id='4' name='rate' type='radio' /> ★★★★<br />";
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
}
