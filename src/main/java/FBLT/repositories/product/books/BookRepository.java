package FBLT.repositories.product.books;

import FBLT.domain.product.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Twaha Nzeyimana
 * @date 26 Septemeber 2016
 * @description Repository for Books
 */

@RepositoryRestResource(collectionResourceRel = "book", path ="book")
public interface BookRepository extends MongoRepository<Book,String> {

}
