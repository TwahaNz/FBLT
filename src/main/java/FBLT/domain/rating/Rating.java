package FBLT.domain.rating;


/**
 * Created by Brandonhome on 2016/09/20.
 */
public class Rating implements IRating {

    private String id;
    private String userID;
    private String advertID;
    private int rating;
    private Comment comment;

    protected Rating() {
    }

    private Rating(Builder builder) {
        this.id = builder.id;
        this.userID = builder.userID;
        this.advertID = builder.advertID;
        this.rating = builder.rating;
        this.comment = builder.comment;
    }

    public Comment getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public static class Builder {
        private String id;
        private String userID;
        private String advertID;
        private int rating;
        private Comment comment;

        public Builder() {

        }

        public Builder copy(Rating rating) {
            this.id = rating.id;
            this.userID = rating.userID;
            this.advertID = rating.advertID;
            this.rating = rating.rating;
            this.comment = rating.comment;
            return this;
        }

        public Builder id(String ratingID) {
            this.id = ratingID;
            return this;
        }

        public Builder comment(Comment comment) {
            this.comment = comment;
            return this;
        }

        public Builder userID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder advertID(String advertID) {
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
