package FBLT.domain.product.electronics.cellphone;

import FBLT.domain.product.category.Category;

/**
 * Created by kraluk01 on 9/21/2016.
 */
public class CellPhone implements ICellPhone {

    private String _id;
    private Category category;
    private String description;
    private String make;
    private String model;
    private String type;

    protected CellPhone()
    {

    }

    private CellPhone(Builder value){

        this._id = value._id;
        this.category = value.category;
        this.description = value.description;
        this.make = value.make;
        this.model = value.model;
        this.type = value.type;

    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String get_id() {
        return _id;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getType() {
        return type;
    }

    public static class Builder {

        private String _id;
        private Category category;
        private String description;
        private String make;
        private String model;
        private String type;


        public Builder() {

        }

        public CellPhone.Builder id(String value) {
            this._id = value;
            return this;
        }

        public CellPhone.Builder category(Category value) {
            this.category= value;
            return this;
        }

        public CellPhone.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public CellPhone.Builder productMake(String value) {
            this.make = value;
            return this;
        }

        public CellPhone.Builder productModel(String value) {
            this.model = value;
            return this;
        }
        public CellPhone.Builder productType(String value) {
            this.type = value;
            return this;
        }

        public CellPhone.Builder copy(CellPhone value) {
            this._id = value._id;
            this.category = value.category;
            this.description = value.description;
            this.make = value.make;
            this.model = value.model;
            this.type = value.type;
            return this;
        }


        public CellPhone build() {

            return new CellPhone(this);
        }
    }

}
