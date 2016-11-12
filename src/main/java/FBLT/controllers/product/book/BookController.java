package FBLT.controllers.product.book;

import FBLT.domain.product.book.Book;
import FBLT.service.product.book.ImplIBookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;

/**
 * Created by Ferin on 2016/11/12.
 */
@Controller
public class BookController {

    @Autowired
    ImplIBookService bookService;

    //-------------------Retrieve Single Book--------------------------------------------------------
    @RequestMapping(value = "/book-controller/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") String id) {
        System.out.println("Fetching request with id: " + id);
        Book request = bookService.readById(id);
        if (request == null) {
            System.out.println("Request with id " + id + "Not Found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(request, HttpStatus.OK);
    }

    //-------------------Retrieve All Books--------------------------------------------------------

    @RequestMapping(value = "/book-controller/", method = RequestMethod.GET)
    public ResponseEntity<Set<Book>> getBooks() {
        Set<Book> requests = bookService.readAll();
        if (requests.isEmpty()) {
            return new ResponseEntity<Set<Book>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND http err 204 no content
        }
        return new ResponseEntity<Set<Book>>(requests, HttpStatus.OK);
    }

    //-------------------Update a Book--------------------------------------------------------
    @RequestMapping(value = "/book-controller/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable("id") String id, @RequestBody String book) {

        Book currentRequest = (Book) bookService.readById(id);

        if (currentRequest == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

        Gson myGson = new Gson();

        Book updatedBook = new Book.Builder()
                .copy(currentRequest)
                .category(myGson.fromJson(book, Book.class).getCategory())
                .productAuthor(myGson.fromJson(book, Book.class).getAuthor())
                .productTitle(myGson.fromJson(book, Book.class).getTitle())
                .productDescription(myGson.fromJson(book, Book.class).getDescription())
                .build();


        bookService.update(updatedBook);
        return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
    }

    //-------------------Insert a Book--------------------------------------------------------
    @RequestMapping(value = "/book-controller/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody Book newBook, UriComponentsBuilder ucBuilder) {

        bookService.create(newBook);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/book-controller/{id}").buildAndExpand(newBook.get_id()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Delete a Book--------------------------------------------------------
    @RequestMapping(value = "/book-controller/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable("id") String id) {
        Book book = bookService.readById(id);

        if (book == null) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        bookService.delete(book);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }

    // CUSTOM CONTROLLERS

    //-------------------Retrieve Books with ISBN--------------------------------------------------------
    @RequestMapping(value = "/book-controller/find-book-by-isbn/{isbn}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBookwithISBN(@PathVariable("isbn") String isbn) {
        System.out.println("Fetching request with isbn: " + isbn);
        Book request = bookService.findByISBN(isbn);
        if (request == null) {
            System.out.println("Request with id " + isbn + "Not Found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(request, HttpStatus.OK);
    }

    //-------------------Retrieve books with specific author--------------------------------------------------------
    @RequestMapping(value = "/book-controller/find-books-by-author/{author}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("author") String author) {
        System.out.println("Fetching books by author: " + author);
        List<Book> request = bookService.findByAuthor(author);
        if (request == null) {
            System.out.println("Request with id " + author + "Not Found");
            return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Book>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve books with specific title--------------------------------------------------------
    @RequestMapping(value = "/book-controller/find-books-by-title/{title}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable("title") String title) {
        System.out.println("Fetching books with title: " + title);
        List<Book> request = bookService.findByTitle(title);
        if (request == null) {
            System.out.println("Request with id " + title + "Not Found");
            return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Book>>(request, HttpStatus.OK);
    }

    //-------------------Retrieve books with specific genre--------------------------------------------------------
    @RequestMapping(value = "/book-controller/find-books-by-genre/{genre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable("genre") String genre) {
        System.out.println("Fetching books with genre: " + genre);
        List<Book> request = bookService.findByGenre(genre);
        if (request == null) {
            System.out.println("Request with id " + genre + "Not Found");
            return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Book>>(request, HttpStatus.OK);
    }
    
}
