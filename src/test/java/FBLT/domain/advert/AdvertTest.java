package FBLT.domain.advert;

import FBLT.domain.product.IProduct;
import FBLT.domain.product.Product;
import FBLT.domain.product.category.Category;
import FBLT.domain.product.vehicle.Vehicle;
import FBLT.service.advert.ImplAdvertService;
import FBLT.utils.genericvalueobjects.Location;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * edited by luke
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

        IProduct mynewProduct = new Vehicle.Builder()
                .category(
                        new Category.Builder()
                                .categoryName("Kids Toys")
                                .categoryDescription("things for kids")
                                .build())
                .productDescription("Barbie Doll")
                .build();

        ArrayList<String> images = new ArrayList<>();

        images.add("C://pic.jpg");
        images.add("C://name.jpg");
        images.add("C://age.jpg");


        Advert myTestAdvert = new Advert.Builder()

                .buyOrSell(false)
                .price(789.44)
                .product(mynewProduct)
                .location(newLocation)
                .imagePaths(images)
                .build();


        Assert.assertNotNull(myTestAdvert);
        Assert.assertEquals("Cape Town", myTestAdvert.getLocation().getCity());
        Assert.assertEquals("Rondebosch", myTestAdvert.getLocation().getSuburb());
        Assert.assertEquals("Barbie Doll",myTestAdvert.getProduct().getDescription());
        Assert.assertNotNull(myTestAdvert.getImagepaths());
        Assert.assertEquals(false,myTestAdvert.isBuyOrSell());


    }

    @Test
    public void testId(){
        ImplAdvertService implAdvertService = new ImplAdvertService();

    }
}

