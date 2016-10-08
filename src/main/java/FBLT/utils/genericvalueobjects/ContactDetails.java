package FBLT.utils.genericvalueobjects;

/**
 * Value object in User class
 */
public class ContactDetails {

    private String emailAddress;
    private String cellPhoneNumber;
    private String telegramHandle;

    protected ContactDetails() {
    }

    public ContactDetails(Builder builder) {
        this.cellPhoneNumber = builder.cellPhoneNumber;
        this.emailAddress = builder.emailAddress;
        this.telegramHandle = builder.telegramHandle;
    }

    public String getTelegramHandle() {
        return telegramHandle;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public static class Builder {

        private String emailAddress;
        private String cellPhoneNumber;
        private String telegramHandle;

        public Builder telegramHandle(String telegramHandle) {
            this.telegramHandle = telegramHandle;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder cellPhoneNumber(String cellPhoneNumber) {
            this.cellPhoneNumber = cellPhoneNumber;
            return this;
        }

        public Builder copy(ContactDetails contactDetails) {
            this.cellPhoneNumber = contactDetails.cellPhoneNumber;
            this.emailAddress = contactDetails.emailAddress;
            this.telegramHandle = contactDetails.telegramHandle;

            return this;
        }

        public ContactDetails build() {
            return new ContactDetails(this);
        }
    }

}
