package FBLT.domain.product.cellphone;

import FBLT.domain.product.category.Category;

/**
 * Created by kraluk01 on 9/21/2016.
 */
public class CellPhone implements ICellPhone {

    private Long productId;
    private Category category;
    private String description;
    private String make;
    private String model;

    private CellPhone()
    {

    }

    private CellPhone(Builder value){

        this.productId = value.productId;
        this.category = value.category;
        this.description = value.description;
        this.make = value.make;
        this.model = value.model;

    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Long getProductId() {
        return productId;
    }

    public Category getCategory() {
        return category;
    }

    public String getProductDescription() {
        return description;
    }

    public static class Builder {

        private Long productId;
        private Category category;
        private String description;
        private String make;
        private String model;


        public Builder() {

        }

        public CellPhone.Builder productID(Long value) {
            this.productId = value;
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

        public CellPhone.Builder copy(CellPhone value) {
            this.productId = value.productId;
            this.category = value.category;
            this.description = value.description;
            this.make = value.make;
            this.model = value.model;
            return this;
        }


        public CellPhone build() {

            return new CellPhone(this);
        }
    }

}
