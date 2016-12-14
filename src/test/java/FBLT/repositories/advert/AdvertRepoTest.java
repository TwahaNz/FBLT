package FBLT.repositories.advert;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.clothing.IClothing;
import FBLT.domain.user.User;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by Brandonhome on 2016/10/08.
 */
public class AdvertRepoTest {
    private static final String TAG = "AdvertRepoTest: ";

    @Test
    public void testCRUD() {

        MongoOperations mongoOps = new MongoTemplate(
                new Mongo(), "FBLT");
        Location newLocation = new Location.Builder()
                .city("Cape Town")
                .suburb("Rondebosch")
                .latitude(22.33)
                .longitude(34.53)
                .build();


        IClothing productTest = new Clothing.Builder()
                .id("1")
                .productDescription("Coach Jacket")
                .productType("Jacket")
                .productBrand("Sol Sol")
                .productGender("male")
                .productAgeGroup("Adult")
                .productSize("medium")
                .productColor("blue")
                .productMaterial("nylon")
                .category(new Category.Builder()
                        .categoryName("Clothing")
                        .categoryDescription("Jacket")
                        .build())
                .build();

        User myUser = new User.Builder()
                .contactDetails(new ContactDetails.Builder()
                        .cellPhoneNumber("0810101966")
                        .emailAddress("example@gmail.com")
                        .telegramHandle("@maybmuzic")
                        .build())
                .location(new Location.Builder()
                        .city("Cape Town")
                        .latitude(new Double(14566.3))
                        .longitude(new Double(7899.3))
                        .suburb("Northern Suburbs")
                        .build())
                .id("MYDAMNID")
                .name("Sally")
                .build();

        Advert myTestAdvert = new Advert.Builder()
                .user(myUser)
                .buyOrSell(false)
                .price(789.44)
                .product(productTest)
                .location(newLocation)
                .build();


        //INSERT
        mongoOps.insert(myTestAdvert);

        Assert.assertFalse(TAG, myTestAdvert.getId().isEmpty());

        //RETRIEVE
        Advert advert = mongoOps.findById(myTestAdvert.getId(), Advert.class);

        Assert.assertEquals(TAG, advert.getProduct().getCategory().getCategoryDescription(), productTest.getCategory().getCategoryDescription());
        Assert.assertEquals(TAG, advert.getUser().getContactDetails().getTelegramHandle(), myUser.getContactDetails().getTelegramHandle());

        //UPDATE
        mongoOps.updateFirst(new Query(where("_id").is(advert.getId())), Update.update("price", 789), Advert.class);

        Assert.assertEquals(789, advert.getPrice(), 1);

        //DELETE
        //mongoOps.remove(advert);


    }
}
