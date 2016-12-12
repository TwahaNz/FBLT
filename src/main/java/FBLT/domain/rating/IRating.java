package FBLT.domain.rating;

/**
 * Created by maybra01 on 9/21/2016.
 */
public interface IRating {

    /**
     * @return returns a value of a particular rating assigned by another member/user to a member seller
     */
    String getRating();

    Comment getComment();
}
