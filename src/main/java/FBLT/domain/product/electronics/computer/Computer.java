package FBLT.domain.product.electronics.computer;

import FBLT.domain.product.category.Category;

/**
 * Created by kraluk01 on 9/27/2016.
 */
public class Computer implements IComputer {
    private String id;
    private Category category;
    private String description;
    private String make;
    private String model;
    private String type;
    private String size;


    protected Computer(){}

    protected Computer(Builder value){

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
    public String getDescription() {
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

        public Computer.Builder id(String value) {
            this.id = value;
            return this;
        }

        public Computer.Builder category(Category value) {
            this.category= value;
            return this;
        }

        public Computer.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Computer.Builder productMake(String value) {
            this.make = value;
            return this;
        }

        public Computer.Builder productModel(String value) {
            this.model = value;
            return this;
        }
        public Computer.Builder productType(String value) {
            this.type = value;
            return this;
        }

        public Computer.Builder productSize(String value) {
            this.size = value;
            return this;
        }

        public Computer.Builder copy(Computer value) {
            this.id = value.id;
            this.category = value.category;
            this.description = value.description;
            this.make = value.make;
            this.model = value.model;
            this.size = value.size;
            this.type = value.type;
            return this;
        }


        public Computer build() {

            return new Computer(this);
        }
    }
}
