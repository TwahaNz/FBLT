package FBLT.factories.product.book;

import FBLT.domain.product.book.Book;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public interface IBookFactory {

    Book getBook(Map<String,String> details);
}
