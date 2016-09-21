package FBLT.domain.product;


import FBLT.domain.product.category.Category;

/**
 * Created by lukekramer on 20/09/2016.
 */
public class Product implements IProduct {

    private Long productId;
    private Category category;
    private String description;

    private Product(Builder b){

        this.productId = b.productId;
        this.category = b.category;
        this.description = b.description;
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

        public Builder() {

        }

        public Product.Builder productID(Long value) {
            this.productId = value;
            return this;
        }

        public Product.Builder category(Category value) {
            this.category= value;
            return this;
        }

        public Product.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Product.Builder copy(Product value) {
            this.productId = value.productId;
            this.category = value.category;
            this.description = value.description;
            return this;
        }


        public Product build() {

            return new Product(this);
        }
    }
}
