package FBLT.factories.product.book;

import FBLT.domain.product.book.Book;
import FBLT.domain.product.category.Category;

import java.util.Map;

/**
 * Created by Brandonhome on 2016/12/12.
 */
public class BookFactoryImpl implements IBookFactory {

    private static BookFactoryImpl factory = null;

    private BookFactoryImpl() {

    }

    public static BookFactoryImpl getInstance() {
        if (factory == null)
            factory = new BookFactoryImpl();

        return factory;
    }

    public Book getBook(Map<String, String> details) {

        Book finalProduct = new Book.Builder().build();

        if (details.containsKey("isbn")) {
            Book bookWithISBN = new Book.Builder()
                    .copy(finalProduct)
                    .productISBN(details.get("isbn"))
                    .build();
            finalProduct = bookWithISBN;

        }
        if (details.containsKey("title")) {
            Book bookWithTitle = new Book.Builder()
                    .copy(finalProduct)
                    .productTitle(details.get("title"))
                    .build();
            finalProduct = bookWithTitle;

        }
        if (details.containsKey("genre")) {
            Book bookWithGenre = new Book.Builder()
                    .copy(finalProduct)
                    .productISBN(details.get("genre"))
                    .build();
            finalProduct = bookWithGenre;

        }
        if (details.containsKey("author")) {
            Book bookWithAuthor = new Book.Builder()
                    .copy(finalProduct)
                    .productISBN(details.get("author"))
                    .build();
            finalProduct = bookWithAuthor;
        }
        if (details.containsKey("category")) {
            Book bookWithAuthor = new Book.Builder()
                    .copy(finalProduct)
                    .category(new Category.Builder().categoryName(details.get("category")).build())
                    .build();
            finalProduct = bookWithAuthor;
        }
        if (details.containsKey("ad-description")) {
            Book bookWithAuthor = new Book.Builder()
                    .copy(finalProduct)
                    .productDescription(details.get("ad-description"))
                    .build();
            finalProduct = bookWithAuthor;
        }


        return finalProduct;


    }

}
