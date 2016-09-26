package FBLT.domain.repositories;

import FBLT.domain.product.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Brandonhome on 2016/09/26.
 */
public interface BookRepository extends MongoRepository<Book,String> {


}
