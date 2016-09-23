package FBLT.domain.rating;

import FBLT.domain.advert.Advert;

/**
 * Created by maybra01 on 9/21/2016.
 */
public class Comment {

    private Long commentID;
    private Long ratingID;
    private String comment;

    private Comment(){

    }

    private Comment(Builder builder) {
        this.commentID = builder.commentID;
        this.comment = builder.comment;
        this.ratingID=builder.ratingID;
    }

    public Long getCommentID() {
        return commentID;
    }

    public Long getRatingID() {
        return ratingID;
    }

    public String getComment() {
        return comment;
    }


    public static class Builder {
        private Long commentID;
        private String comment;
        private Long ratingID;

        public Builder() {

        }

        public Builder ratingID(Long ratingID) {
            this.ratingID = ratingID;
            return this;
        }

        public Builder commentID(Long commentID) {
            this.commentID = commentID;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder copy(Comment comment) {
            this.commentID = comment.commentID;
            this.ratingID = comment.ratingID;
            this.comment = comment.comment;
            return this;

        }

        public Comment build() {
            return new Comment(this);
        }

    }



}
