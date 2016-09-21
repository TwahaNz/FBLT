package FBLT.domain.user;

import FBLT.utils.genericvalueobjects.Location;

/**
 * This class deals with the user who refers to both the buyer and seller
 */

public class User {

    private Long userId;
    private ContactDetails contactDetails;
    private String name;
    private Location location;

    /* The ranking is an average of all the users rating, if they get an average of 7/10 for example they are a very reliable
    *  This is going to be composition */
    private int ranking;

    private User(){}

    private User(Builder builder) {
        this.userId = builder.userId;
        this.contactDetails = builder.contactDetails;
        this.name = builder.name;
        this.location = builder.location;
        this.ranking = builder.ranking;
    }

    public Long getUserId() {
        return userId;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public int getRanking() {
        return ranking;
    }

    public static class Builder{
        private Long userId;
        private ContactDetails contactDetails;
        private String name;
        private Location location;
        private int ranking;

        public Builder userId(Long userId){
            this.userId = userId;
            return this;
        }

        public Builder contactDetails(ContactDetails contactDetails){
            this.contactDetails = contactDetails;
            return  this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder location(Location location){
            this.location = location;
            return  this;
        }

        public Builder ranking(int ranking){
            this.ranking = ranking;
            return this;
        }

        public Builder copy(User user){
            this.userId = user.userId;
            this.contactDetails = user.contactDetails;
            this.name = user.name;
            this.location = user.location;
            this.ranking = user.ranking;

            return  this;
        }

        public User build(){
            return new User(this);
        }

    }


}
