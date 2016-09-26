package FBLT.domain.product.category;

/**
 * Created by Brandonhome on 2016/09/20.
 */
public class Category implements ICategory{

    private String categoryName;
    private String categoryDescription;

    protected Category(){

    }

    private Category(Builder b){

        this.categoryName = b.categoryName;
        this.categoryDescription = b.categoryDescription;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public static class Builder{

        private String categoryName;
        private String categoryDescription;

        public Builder() {

        }

        public Builder categoryName(String name){
            this.categoryName = name;
            return this;
        }

        public Builder categoryDescription(String description){
            this.categoryDescription =description;
            return this;
        }

        public Category build(){

            return new Category(this);
        }


    }

}
