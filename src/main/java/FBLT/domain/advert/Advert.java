package FBLT.domain.advert;

import FBLT.domain.product.IProduct;
import FBLT.domain.product.book.Book;
import FBLT.domain.product.clothing.Clothing;
import FBLT.domain.product.electronics.audio.Audio;
import FBLT.domain.product.electronics.cellphone.CellPhone;
import FBLT.domain.product.electronics.computer.Computer;
import FBLT.domain.product.electronics.television.Television;
import FBLT.domain.product.livestock.Livestock;
import FBLT.domain.product.shoes.Shoes;
import FBLT.domain.product.vehicle.Vehicle;
import FBLT.domain.user.User;
import FBLT.utils.genericvalueobjects.Location;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by Brandonhome on 2016/09/20.
 */

public class Advert implements IAdvert {

    @Id
    private String id;
    private String title;
    private User user;
    private ArrayList<String> imagepaths;

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "_class")
    @JsonSubTypes({
            @JsonSubTypes.Type(name = "FBLT.domain.product.clothing.Clothing", value = Clothing.class),
            @JsonSubTypes.Type(name = "FBLT.domain.product.book.Book", value = Book.class),
            @JsonSubTypes.Type(name = "FBLT.domain.product.electronics.audio.Audio", value = Audio.class),
            @JsonSubTypes.Type(name = "FBLT.domain.product.electronics.cellphone.CellPhone", value = CellPhone.class),
            @JsonSubTypes.Type(name = "FBLT.domain.product.electronics.computer.Computer", value = Computer.class),
            @JsonSubTypes.Type(name = "FBLT.domain.product.electronics.television.Television", value = Television.class),
            @JsonSubTypes.Type(name = "FBLT.domain.product.livestock.Livestock", value = Livestock.class),
            @JsonSubTypes.Type(name = "FBLT.domain.product.shoes.Shoes", value = Shoes.class),
            @JsonSubTypes.Type(name = "FBLT.domain.product.vehicle.Vehicle", value = Vehicle.class)

    })
    @JsonTypeId
    private IProduct product;
    private boolean buyOrSell;
    private double price;
    private Location location;

    protected Advert() {
    }

    private Advert(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.user = builder.user;
        this.product = builder.product;
        this.buyOrSell = builder.buyOrSell;
        this.price = builder.price;
        this.location = builder.location;
        this.imagepaths = builder.imagepaths;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public IProduct getProduct() {
        return product;
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

    public ArrayList<String> getImagepaths() {
        return imagepaths;
    }

    public static class Builder {

        private String id;
        private User user;
        private String title;
        private ArrayList<String> imagepaths;
        private IProduct product;
        private boolean buyOrSell;
        private double price;
        private Location location;

        public Builder() {

        }

        public Builder copy(Advert advert) {
            this.id = advert.id;
            this.title = advert.title;
            this.user = advert.user;
            this.product = advert.product;
            this.buyOrSell = advert.buyOrSell;
            this.price = advert.price;
            this.location = advert.location;
            this.imagepaths = advert.imagepaths;
            return this;

        }

        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder product(IProduct product) {
            this.product = product;
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

        public Builder imagePaths(ArrayList<String> imagepaths) {
            this.imagepaths = imagepaths;
            return this;

        }

        public Advert build() {
            return new Advert(this);
        }


    }


}