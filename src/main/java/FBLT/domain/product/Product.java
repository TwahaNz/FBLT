package FBLT.domain.product;


import FBLT.domain.product.category.Category;

/**
 * Created by lukekramer on 20/09/2016.
 */
public class Product implements IProduct {

    private String _id;
    private Category category;
    private String description;

    protected Product() {

    }

    private Product(Builder b) {
        this._id = b.id;
        this.category = b.category;
        this.description = b.description;
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

    public static class Builder {

        private String id;
        private Category category;
        private String description;

        public Builder() {

        }

        public Product.Builder id(String value) {
            this.id = value;
            return this;
        }

        public Product.Builder category(Category value) {
            this.category = value;
            return this;
        }

        public Product.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Product.Builder copy(Product value) {
            this.id = value._id;
            this.category = value.category;
            this.description = value.description;
            return this;
        }


        public Product build() {

            return new Product(this);
        }
    }
}
