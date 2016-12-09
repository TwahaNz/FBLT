package FBLT.domain.product.livestock;

import FBLT.domain.product.category.Category;

/**
 * Created by kraluk01 on 9/21/2016.
 */
public class Livestock implements ILivestock {

    private String _id;
    private Category category;
    private String description;
    private String age;
    private String grade;

    protected Livestock() {

    }

    private Livestock(Builder value) {

        this._id = value._id;
        this.category = value.category;
        this.description = value.description;
        this.age = value.age;
        this.grade = value.grade;

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

    public String getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public static class Builder {

        private String _id;
        private Category category;
        private String description;
        private String age;
        private String grade;

        public Builder() {

        }

        public Livestock.Builder id(String value) {
            this._id = value;
            return this;
        }

        public Livestock.Builder category(Category value) {
            this.category = value;
            return this;
        }

        public Livestock.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Livestock.Builder productAge(String value) {
            this.age = value;
            return this;
        }

        public Livestock.Builder productGrade(String value) {
            this.grade = value;
            return this;
        }

        public Livestock.Builder copy(Livestock value) {
            this._id = value._id;
            this.category = value.category;
            this.description = value.description;
            this.age = value.age;
            this.grade = value.grade;
            return this;
        }


        public Livestock build() {

            return new Livestock(this);
        }
    }
}
