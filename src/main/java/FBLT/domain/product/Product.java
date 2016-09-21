package FBLT.domain.product;



/**
 * Created by lukekramer on 20/09/2016.
 */
public class Product implements IProduct {

    private Long productId;
    private Long catagoryId;
    private String description;

    private Product(Builder b){

        this.productId = b.productId;
        this.catagoryId = b.catagoryId;
        this.description = b.description;
    }


    public Long getProductId() {
        return productId;
    }

    public Long getCatagoryId() {
        return catagoryId;
    }

    public String getProductDescription() {
        return description;
    }

    public static class Builder {

        private Long productId;
        private Long catagoryId;
        private String description;

        public Builder() {

        }

        public Product.Builder productID(Long value) {
            this.productId = value;
            return this;
        }

        public Product.Builder categoryID(Long value) {
            this.catagoryId = value;
            return this;
        }

        public Product.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Product.Builder copy(Product value) {
            this.productId = value.productId;
            this.catagoryId = value.catagoryId;
            this.description = value.description;
            return this;
        }


        public Product build() {

            return new Product(this);
        }
    }
}
