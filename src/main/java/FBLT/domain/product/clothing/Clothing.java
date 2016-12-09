package FBLT.domain.product.clothing;

import FBLT.domain.product.category.Category;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public class Clothing implements IClothing {

    private String _id;
    private Category category;
    private String description;
    private String type;
    private String brand;
    private String gender;
    private String age;
    private String size;
    private String color;
    private String material;

    protected Clothing() {

    }

    private Clothing(Builder value) {

        this._id = value._id;
        this.category = value.category;
        this.description = value.description;
        this.type = value.type;
        this.brand = value.brand;
        this.gender = value.gender;
        this.age = value.age;
        this.size = value.size;
        this.color = value.color;
        this.material = value.material;

    }


    @Override
    public String getClothingType() {
        return type;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getAge() {
        return age;
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
    public String getMaterial() {
        return material;
    }

    public String get_id() {
        return _id;
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

        private String _id;
        private Category category;
        private String description;
        private String type;
        private String brand;
        private String gender;
        private String age;
        private String size;
        private String color;
        private String material;

        public Builder() {

        }

        public Clothing.Builder id(String value) {
            this._id = value;
            return this;
        }

        public Clothing.Builder category(Category value) {
            this.category = value;
            return this;
        }

        public Clothing.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Clothing.Builder productType(String value) {
            this.type = value;
            return this;
        }

        public Clothing.Builder productBrand(String value) {
            this.brand = value;
            return this;
        }

        public Clothing.Builder productGender(String value) {
            this.gender = value;
            return this;
        }

        public Clothing.Builder productAgeGroup(String value) {
            this.age = value;
            return this;
        }

        public Clothing.Builder productSize(String value) {
            this.size = value;
            return this;
        }

        public Clothing.Builder productColor(String value) {
            this.color = value;
            return this;
        }

        public Clothing.Builder productMaterial(String value) {
            this.material = value;
            return this;
        }

        public Clothing.Builder copy(Clothing value) {
            this._id = value._id;
            this.category = value.category;
            this.description = value.description;
            this.type = value.type;
            this.brand = value.brand;
            this.gender = value.gender;
            this.age = value.age;
            this.size = value.size;
            this.color = value.color;
            this.material = value.material;
            return this;
        }

        public Clothing build() {

            return new Clothing(this);
        }
    }


}
