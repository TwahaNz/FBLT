package FBLT.repositories.advert;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.clothing.IClothing;
import FBLT.domain.user.User;
import FBLT.service.advert.IAdvertService;
import FBLT.service.advert.ImplAdvertService;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import com.mongodb.Mongo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.mockito.Mockito.when;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by Brandonhome on 2016/10/08.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdvertRepoTest {

    @Mock
    private IAdvertService service;

    private Advert productTest,product;

    @Before
    public void setup(){

        Location newLocation = new Location.Builder()
                .city("Cape Town")
                .suburb("Rondebosch")
                .latitude(22.33)
                .longitude(34.53)
                .build();

        Location location = new Location.Builder()
                .city("Joburg")
                .suburb("Sandton")
                .build();

        IClothing clothing = new Clothing.Builder()
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

        productTest = new Advert.Builder()
                .user(myUser)
                .buyOrSell(false)
                .price(789.44)
                .product(clothing)
                .location(newLocation)
                .build();

        product = new Advert.Builder()
                .location(location)
                .build();

        service = Mockito.mock(ImplAdvertService.class);


    }

    @Test
    public void testCRUD() {

        //Create
        when(service.create(product)).thenReturn(productTest);

        Assert.assertNotNull(service.create(product));

        //Find

        when(service.readById("1")).thenReturn(product);

        Assert.assertNotNull(service.readById("1"));

        Assert.assertEquals(service.readById("1").getLocation().getCity(),"Joburg");

        //Update

        //Author Updated

        when(service.update(product)).thenReturn(productTest);

        Assert.assertNotNull(service.update(product));

        Assert.assertEquals(service.update(product).getLocation().getCity(),"Cape Town");

        //Delete

        Assert.assertNotNull(service.create(product));

        service.delete(service.create(product));


    }
}
