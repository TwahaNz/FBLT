package FBLT.utils.geolocation;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by nzetwa01 on 10/7/2016.
 */
public class GeolocationFinderTest {

    private static final String TAG = "Geolocation Ftnder: ";
    private GeolocationFinder geolocationFinder;

    @Before
    public void setup() throws IOException {

        LookupService lookupService = new LookupService("geo/GeoLiteCity.dat",
                LookupService.GEOIP_MEMORY_CACHE | LookupService.GEOIP_CHECK_CACHE);

         geolocationFinder = new GeolocationFinder.Builder()

                .setUpLookupService()
                .setIPAdress("takealot.co.za")
                .setLocation(new Location())
                .build();
    }

    @Test
    public void whenAccessingTheLocationClassForTheCity_ReturnTheCorrectIpDetails() {
        Assert.assertEquals(TAG, "Kempton Park", geolocationFinder.getCity());
        Assert.assertEquals(TAG, "0", geolocationFinder.getAreaCode());
        Assert.assertEquals(TAG, "South Africa", geolocationFinder.getCountry());
        Assert.assertEquals(TAG, "1618", geolocationFinder.getPostalCode());
        Assert.assertEquals(TAG, "28.233002", geolocationFinder.getLongitude());
        Assert.assertEquals(TAG, "-26.0988", geolocationFinder.getLatitude());
    }
}
