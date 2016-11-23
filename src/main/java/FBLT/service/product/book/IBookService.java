package FBLT.service.product.book;


import FBLT.domain.product.book.Book;
import FBLT.service.Service;

import java.util.List;

/**
 * Created by Ferin on 2016/11/12.
 */
public interface IBookService extends Service<Book, String>{

    Book findByISBN(String ISBN);

    List<Book> findByAuthor(String Author);

    List<Book> findByTitle(String Author);

    List<Book> findByGenre(String genre);

}
