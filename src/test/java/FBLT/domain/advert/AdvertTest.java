package FBLT.domain.advert;

import FBLT.utils.genericvalueobjects.Location;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

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

        Advert myTestAdvert = new Advert.Builder()
                .advertID(new Long(1))
                .buyOrSell(false)
                .price(789.44)
                .userID(new Long(5))
                .location(newLocation)
                .build();


        Assert.assertNotNull(myTestAdvert);
        Assert.assertEquals("Cape Town", myTestAdvert.getLocation().getCity());
        Assert.assertEquals("Rondebosch", myTestAdvert.getLocation().getSuburb());
        Assert.assertEquals(false,myTestAdvert.isBuyOrSell());


    }
}
