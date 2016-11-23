package FBLT.utils.geolocation;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

import java.io.IOException;

/**
 * Created by nzetwa01 on 10/7/2016.
 */
public class GeolocationFinder {

    private final Location location;
    private final LookupService lookupService;

    private GeolocationFinder(Builder builder) {
        this.location = builder.location;
        this.lookupService = builder.lookupService;
    }

    public String getCity() {
        return this.location.city;
    }

    public String getCountry() {
        return this.location.countryName;
    }

    public String getPostalCode() {
        return this.location.postalCode;
    }

    public String getRegion() {
        return this.location.region;
    }

    public String getAreaCode() {
        return "" + this.location.area_code;
    }

    public String getLongitude() {
        return  "" + this.location.longitude;
    }

    public String getLatitude() {
        return  "" + this.location.latitude;
    }

    public static class Builder {

        private static final String MAP_FILE_DATA = "geo/GeoLiteCity.dat";
        private Location location;
        private LookupService lookupService;
        private String ipAdress;

        public Builder setLocation(Location location) {
            this.location = location;

            return this;
        }

        public Builder setIPAdress(String ipAdrress) {
            this.ipAdress = ipAdrress;
            return this;
        }

        public Builder setUpLookupService() throws IOException {
            lookupService =  new LookupService(MAP_FILE_DATA,
                    LookupService.GEOIP_MEMORY_CACHE | LookupService.GEOIP_CHECK_CACHE);
            return this;
        }

        public GeolocationFinder build() {
            this.location = this.lookupService.getLocation(this.ipAdress);
            return new GeolocationFinder(this);
        }
    }
}
