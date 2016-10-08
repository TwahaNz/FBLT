package FBLT.domain.advert;

import FBLT.domain.product.Product;
import FBLT.domain.product.category.Category;
import FBLT.utils.genericvalueobjects.Location;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Brandonhome on 2016/09/23.
 */
public class AdvertTest {

    @Test
    public void testAdvertCreation(){

        Location newLocation = new Location.Builder()
                .city("Cape Town")
                .suburb("Rondebosch")
                .latitude(22.33)
                .longitude(34.53)
                .build();

        Product mynewProduct = new Product.Builder()
                .category(
                        new Category.Builder()
                                .categoryName("Kids Toys")
                        .categoryDescription("things for kids")
                        .build())
                .productDescription("Barbie Doll")
                .build();

        Advert myTestAdvert = new Advert.Builder()

                .buyOrSell(false)
                .price(789.44)
                .product(mynewProduct)
                .location(newLocation)
                .build();


        Assert.assertNotNull(myTestAdvert);
        Assert.assertEquals("Cape Town", myTestAdvert.getLocation().getCity());
        Assert.assertEquals("Rondebosch", myTestAdvert.getLocation().getSuburb());
        Assert.assertEquals("Barbie Doll",myTestAdvert.getProduct().getDescription());
        Assert.assertEquals(false,myTestAdvert.isBuyOrSell());


    }
}
