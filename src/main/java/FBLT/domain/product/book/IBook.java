package FBLT.domain.product.book;

import FBLT.domain.product.IProduct;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public interface IBook extends IProduct {

    /**
     *
     * @return returns a String with a book title
     */

    String getTitle();

    /**
     *
     * @return returns a String with book ISBN
     */

    String getISBN();

    /**
     *
     * @return returns a String with book Genre
     */

    String getGenre();

}
