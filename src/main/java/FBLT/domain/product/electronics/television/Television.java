package FBLT.domain.product.electronics.television;

import FBLT.domain.product.category.Category;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public class Television implements ITelevision {

    private String id;
    private Category category;
    private String description;
    private String make;
    private String model;
    private String type;
    private String size;


    protected Television(){}

     protected Television(Builder value){

        this.id = value.id;
        this.category = value.category;
        this.description = value.description;
        this.make = value.make;
        this.model = value.model;
        this.type = value.type;
        this.size = value.size;

    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
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
    public String getProductDescription() {
        return description;
    }

    public static class Builder {

        private String id;
        private Category category;
        private String description;
        private String make;
        private String model;
        private String type;
        private String size;


        public Builder() {

        }

        public Television.Builder id(String value) {
            this.id = value;
            return this;
        }

        public Television.Builder category(Category value) {
            this.category= value;
            return this;
        }

        public Television.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Television.Builder productMake(String value) {
            this.make = value;
            return this;
        }

        public Television.Builder productModel(String value) {
            this.model = value;
            return this;
        }
        public Television.Builder productType(String value) {
            this.type = value;
            return this;
        }

        public Television.Builder productSize(String value) {
            this.size = value;
            return this;
        }

        public Television.Builder copy(Television value) {
            this.id = value.id;
            this.category = value.category;
            this.description = value.description;
            this.make = value.make;
            this.model = value.model;
            this.size = value.size;
            this.type = value.type;
            return this;
        }


        public Television build() {

            return new Television(this);
        }
    }
}
