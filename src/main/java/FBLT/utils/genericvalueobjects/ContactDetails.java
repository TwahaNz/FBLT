package FBLT.utils.genericvalueobjects;

/**
 *
 * Value object in User class
 *
 */
public class ContactDetails {

    private String emailAddress;
    private String cellPhoneNumber;

    private ContactDetails(){}

    public ContactDetails(Builder builder){
        this.cellPhoneNumber = builder.cellPhoneNumber;
        this.emailAddress = builder.emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public static class Builder{

        private String emailAddress;
        private String cellPhoneNumber;

        public Builder emailAddress(String emailAddress){
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder cellPhoneNumber(String cellPhoneNumber){
            this.cellPhoneNumber = cellPhoneNumber;
            return this;
        }

        public Builder copy(ContactDetails contactDetails){
            this.cellPhoneNumber = contactDetails.cellPhoneNumber;
            this.emailAddress = contactDetails.emailAddress;

            return this;
        }

        public ContactDetails build(){
            return new ContactDetails(this);
        }
    }

}
