package FBLT.repositories.product.books;

import FBLT.domain.product.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Books
 */

public interface BookRepository extends MongoRepository<Book,String> {

    /**
     *
     * @param isbn The books isbn number
     * @return book with that isbn number
     *
     */

    @Query(value = "{ 'isbn' : ?0 }")
    Book findbyisbn(String isbn);

    /**
     *
     * @param title The books title
     * @return list of books with that title.
     *
     */
    @Query(value = "{ 'title' : ?0 }")
    List<Book> findbytitle(String title);

    /**
     *
     * @param genre The books genre
     * @return list of books with that title.
     *
     */
    @Query(value = "{ 'genre' : ?0 }")
    List<Book> findbygenre(String genre);

    /**
     *
     * @param author The books author
     * @return list of books with that author.
     *
     */
    @Query(value = "{ 'author' : ?0 }")
    List<Book> findbyauthor(String author);


}
