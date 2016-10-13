package FBLT.services;

import FBLT.domain.advert.Advert;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.clothing.IClothing;
import FBLT.domain.user.User;
import FBLT.service.advert.ImplAdvertService;
import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by maybra01 on 10/13/2016.
 */
public class AdvertServiceTest {


    @Test
    public void testServiceCreation() {

        ImplAdvertService service = new ImplAdvertService();

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



        //CREATE
        Advert concernedAdvert = service.create(myTestAdvert);

        String id = concernedAdvert.getId();
        //READ
        concernedAdvert = service.readById(id);

        Assert.assertNotNull(concernedAdvert);
        Assert.assertEquals(concernedAdvert.getLocation().getCity(), "Cape Town");

        //UPDATE
        newLocation = new Location.Builder()
                .city("Bellville")
                .suburb("Rondebosch")
                .latitude(22.33)
                .longitude(34.53)
                .build();
        Advert updatedAdvert = new Advert.Builder().copy(concernedAdvert)
                .location(newLocation)
                .build();

        concernedAdvert = service.update(updatedAdvert);

        Assert.assertEquals("Bellville", concernedAdvert.getLocation().getCity());


        //DELETE

        service.delete(concernedAdvert);

        concernedAdvert=service.readById(id);
        Assert.assertNull(concernedAdvert);



    }


}
