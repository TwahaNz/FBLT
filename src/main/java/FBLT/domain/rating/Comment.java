package FBLT.domain.rating;

/**
 * Created by maybra01 on 9/21/2016.
 */
public class Comment {

    private String id;
    private String ratingID;
    private String comment;

    protected Comment(){

    }

    private Comment(Builder builder) {
        this.id = builder.id;
        this.comment = builder.comment;
        this.ratingID=builder.ratingID;
    }

    public String getId() {
        return id;
    }

    public String getRatingID() {
        return ratingID;
    }

    public String getComment() {
        return comment;
    }


    public static class Builder {
        private String id;
        private String comment;
        private String ratingID;

        public Builder() {

        }

        public Builder ratingID(String ratingID) {
            this.ratingID = ratingID;
            return this;
        }

        public Builder id(String commentID) {
            this.id = commentID;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder copy(Comment comment) {
            this.id = comment.id;
            this.ratingID = comment.ratingID;
            this.comment = comment.comment;
            return this;

        }

        public Comment build() {
            return new Comment(this);
        }

    }



}
