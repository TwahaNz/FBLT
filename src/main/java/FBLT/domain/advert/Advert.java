package FBLT.domain.advert;

import FBLT.utils.genericvalueobjects.Location;

/**
 * Created by Brandonhome on 2016/09/20.
 */
public class Advert implements IAdvert {

    private Long advertID;
    private Long userID;
    private Long productID;
    private boolean buyOrSell;
    private double price;
    private Location location;

    private Advert() {
    }

    private Advert(Builder builder) {
        this.advertID = builder.advertID;
        this.userID = builder.userID;
        this.productID = builder.productID;
        this.buyOrSell = builder.buyOrSell;
        this.price = builder.price;
        this.location = builder.location;
    }



    public Long getAdvertID() {
        return advertID;
    }

    public Long getUserID() {
        return userID;
    }

    public Long getProductID() {
        return productID;
    }

    public boolean isBuyOrSell() {
        return buyOrSell;
    }

    public double getPrice() {
        return price;
    }

    public Location getLocation() {
        return location;
    }

    public static class Builder {

        private Long advertID;
        private Long userID;
        private Long productID;
        private boolean buyOrSell;
        private double price;
        private Location location;

        public Builder() {

        }

        public Builder copy(Advert advert) {
            this.advertID = advert.advertID;
            this.userID = advert.userID;
            this.productID = advert.productID;
            this.buyOrSell = advert.buyOrSell;
            this.price = advert.price;
            this.location = advert.location;
            return this;

        }

        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        public Builder advertID(Long advertID) {
            this.advertID = advertID;
            return this;
        }

        public Builder userID(Long userID) {
            this.userID = userID;
            return this;
        }

        public Builder productID(Long productID) {
            this.productID = productID;
            return this;

        }

        public Builder buyOrSell(boolean buyOrSell) {
            this.buyOrSell = buyOrSell;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;

        }

        public Advert build() {
            return new Advert(this);
        }


    }


}
