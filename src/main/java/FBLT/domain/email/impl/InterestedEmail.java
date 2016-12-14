package FBLT.domain.email.impl;

import FBLT.domain.advert.Advert;
import FBLT.domain.email.Email;
import FBLT.utils.email.EmailConstants;
import FBLT.utils.genericvalueobjects.ContactDetails;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class sends an email to a seller alerting them of a possible buyer
 */
public class InterestedEmail implements Email {

    private Advert advert;

    // This is an object of the possible buys contact details
    private ContactDetails contactDetails;
    private String name;

    private InterestedEmail() {
    }

    public InterestedEmail(Builder builder) {
        this.advert = builder.advert;
        this.contactDetails = builder.contactDetails;
        this.name = builder.name;
    }

    public Advert getAdvert() {
        return advert;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean sendEmail() {
        try {
            EmailConstants emailConstants = new EmailConstants();

            // Create a default MimeMessage object.
            Message message = new MimeMessage(emailConstants.getSession());

            message.setFrom(new InternetAddress(emailConstants.getFrom()));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(advert.getUser().getContactDetails().getEmailAddress()));

            message.setSubject("do-not-reply");

            message.setText("Hello " + advert.getUser().getName() + ", Great news.. \n" +
                    name + " is interested in your advert:\n" +
                    "Category: " + advert.getProduct().getCategory().getCategoryName() +
                    "\nDescription: " + advert.getProduct().getDescription() +
                    "\nPrice: R" + advert.getPrice() + "\n" +
                    "Please contact them on: \n" +
                    "Cellphone number: " + contactDetails.getCellPhoneNumber() +
                    "\nEmail Address: " + contactDetails.getEmailAddress()
                    + "\n\n\nRegards\nDev Team");


            Transport.send(message);

            System.out.println("Message sent successfully");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static class Builder {
        private Advert advert;

        // This is an object of the possible buys contact details
        private ContactDetails contactDetails;
        private String name;

        public Builder adver(Advert advert) {
            this.advert = advert;
            return this;
        }

        public Builder contactDetails(ContactDetails contactDetails) {
            this.contactDetails = contactDetails;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(InterestedEmail interestedEmail) {
            this.name = interestedEmail.name;
            this.contactDetails = interestedEmail.contactDetails;
            this.advert = interestedEmail.advert;

            return this;
        }

        public InterestedEmail build() {
            return new InterestedEmail(this);
        }

    }
}
