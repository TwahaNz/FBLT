package FBLT.service.product.book;

import FBLT.domain.product.book.Book;
import FBLT.repositories.product.books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Ferin on 2016/11/12.
 */
public class ImplIBookService implements IBookService {

    @Autowired
    BookRepository repository;


    @Override
    public Book findByISBN(String ISBN) {
        return repository.findbyisbn(ISBN);
    }

    @Override
    public List<Book> findByAuthor(String Author) {
        return repository.findbyauthor(Author);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return repository.findbytitle(title);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return repository.findbygenre(genre);
    }

    @Override
    public Book create(Book entity) {
        return repository.save(entity);
    }

    @Override
    public Book readById(String s) {
        return repository.findOne(s);
    }

    @Override
    public Set<Book> readAll() {
        Set<Book> result = new HashSet<Book>();

        Iterator iterator = repository.findAll().iterator();
        while(iterator.hasNext()){
            result.add((Book) iterator.next());
        }
        return result;
    }

    @Override
    public Book update(Book entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Book entity) {
        repository.delete(entity);
    }
}
