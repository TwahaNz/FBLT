package FBLT.utils.genericvalueobjects;

/**
 * Created by tayfer01 on 9/21/2016.
 */

public class Location {


    private double latitude;
    private double longitude;

    private String province;
    private String city;
    private String suburb;


    private Location() {
    }

    public Location(Builder builder) {
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.province = builder.province;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getSuburb() {
        return suburb;
    }

    public static class Builder {

        private double latitude;
        private double longitude;
        private String province;
        private String city;
        private String suburb;

        public Builder province(String province) {
            this.province = province;
            return this;
        }

        public Builder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder suburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder copy(Location location) {
            this.latitude = location.latitude;
            this.longitude = location.longitude;
            this.suburb = location.suburb;
            this.city = location.city;
            this.province = location.province;

            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }

}
