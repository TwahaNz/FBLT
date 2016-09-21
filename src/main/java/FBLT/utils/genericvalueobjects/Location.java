package FBLT.utils.genericvalueobjects;

/**
 * Created by tayfer01 on 9/21/2016.

 */

public class Location {


    private double latitude;
    private double longitude;
    private String suburb;
    private String city;


    private Location(){}

    public Location(Builder builder){
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.suburb = builder.suburb;
        this.city = builder.suburb;
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

    public static class Builder{

        private double latitude;
        private double longitude;
        private String suburb;
        private String city;

        public Builder latitude(double latitude){
            this.latitude = latitude;
            return this;
        }

        public Builder longitude(double longitude){
            this.longitude = longitude;
            return this;
        }

        public Builder suburb(String suburb){
            this.suburb = suburb;
            return this;
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }

        public Builder copy(Location location){
            this.latitude = location.latitude;
            this.longitude = location.longitude;
            this.suburb = location.suburb;
            this.city = location.suburb;

            return this;
        }

        public Location build(){
            return new Location(this);
        }
    }

}
