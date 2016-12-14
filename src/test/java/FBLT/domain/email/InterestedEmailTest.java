package FBLT.domain.email;

import FBLT.domain.advert.Advert;
import FBLT.domain.email.impl.InterestedEmail;
import FBLT.domain.product.IProduct;
import FBLT.domain.product.Product;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.category.ICategory;
import FBLT.domain.user.User;
import FBLT.utils.genericvalueobjects.ContactDetails;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by student on 2016/09/25.
 */

public class InterestedEmailTest {
    @Test
    public void whenThisTestPasses_thenAnEmailHasBeenSent() throws Exception {

        ContactDetails contactDetails = new ContactDetails.Builder()
                .cellPhoneNumber("0810101966")
                .emailAddress("ferintaylor@gmail.com")
                .build();

        User user = new User.Builder()
                .id("1")
                .contactDetails(contactDetails)
                .location(null)
                .name("Ferin")
                .rating(5)
                .build();

        ICategory category = new Category.Builder()
                .categoryName("Book")
                .categoryDescription("Short Description")
                .build();


        IProduct product = new Product.Builder()
                .category((Category) category)
                .productDescription("A nice book")
                .id("1")
                .build();

        Advert advert = new Advert.Builder()
                .id(new String("1"))
                .buyOrSell(false)
                .product((Product) product)
                .user(user)
                .price(new Double(749.99))
                .build();


        ContactDetails buyerContactDetails = new ContactDetails.Builder()
                .cellPhoneNumber("0810101966")
                .emailAddress("example@gmail.com")
                .build();

        InterestedEmail interestedEmail = new InterestedEmail.Builder()
                .adver(advert)
                .contactDetails(buyerContactDetails)
                .name("Mary") // buyers name
                .build();

        Assert.assertTrue(interestedEmail.sendEmail());

    }
}

