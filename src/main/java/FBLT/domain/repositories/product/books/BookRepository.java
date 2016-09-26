package FBLT.domain.repositories.product.books;

import FBLT.domain.product.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Brandonhome on 2016/09/26.
 */

@RepositoryRestResource(collectionResourceRel = "book", path ="book")
public interface BookRepository extends MongoRepository<Book,String> {

}
