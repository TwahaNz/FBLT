package FBLT.domain.rating;


/**
 * Created by Brandonhome on 2016/09/20.
 */
public class Rating implements IRating {

    private Long ratingID;
    private Long userID;
    private Long advertID;
    private int rating;

    private Rating() {
    }

    private Rating(Builder builder) {
        this.ratingID = builder.ratingID;
        this.userID = builder.userID;
        this.advertID = builder.advertID;
        this.rating = builder.rating;

    }

    public int getRating() {
        return rating;
    }

    public static class Builder {
        private Long ratingID;
        private Long userID;
        private Long advertID;
        private int rating;

        public Builder() {

        }

        public Builder copy(Rating rating) {
            this.ratingID = rating.ratingID;
            this.userID = rating.userID;
            this.advertID = rating.advertID;
            this.rating = rating.rating;
            return this;
        }

        public Builder ratingID(Long ratingID) {
            this.ratingID = ratingID;
            return this;
        }

        public Builder userID(Long userID) {
            this.userID = userID;
            return this;
        }

        public Builder advertID(Long advertID) {
            this.advertID = advertID;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Rating build() {
            return new Rating(this);
        }


    }


}
