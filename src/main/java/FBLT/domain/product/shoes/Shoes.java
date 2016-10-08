package FBLT.domain.product.shoes;

import FBLT.domain.product.category.Category;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public class Shoes implements IShoes {

    private String id;
    private Category category;
    private String description;
    private String type;
    private String brand;
    private String size;
    private String color;

    protected Shoes(){}

    private Shoes(Builder value){

        this.id = value.id;
        this.category = value.category;
        this.description = value.description;
        this.type = value.type;
        this.brand = value.brand;
        this.size = value.size;
        this.color = value.color;
    }


    @Override
    public String getShoeType() {
        return type;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static class Builder {

        private String id;
        private Category category;
        private String description;
        private String type;
        private String brand;
        private String size;
        private String color;


        public Builder() {

        }

        public Shoes.Builder id(String value) {
            this.id = value;
            return this;
        }

        public Shoes.Builder category(Category value) {
            this.category= value;
            return this;
        }

        public Shoes.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Shoes.Builder productType(String value) {
            this.type = value;
            return this;
        }

        public Shoes.Builder productBrand(String value) {
            this.brand = value;
            return this;
        }


        public Shoes.Builder productSize(String value) {
            this.size = value;
            return this;
        }

        public Shoes.Builder productColor(String value) {
            this.color = value;
            return this;
        }


        public Shoes.Builder copy(Shoes value) {
            this.id = value.id;
            this.category = value.category;
            this.description = value.description;
            this.type = value.type;
            this.brand = value.brand;
            this.size = value.size;
            this.color = value.color;
            return this;
        }

        public Shoes build() {

            return new Shoes(this);
        }
    }

}
