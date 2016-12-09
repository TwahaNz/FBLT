package FBLT.domain.product.electronics.audio;

import FBLT.domain.product.category.Category;


/**
 * Created by kraluk01 on 9/27/2016.
 */
public class Audio implements IAudio {
    private String _id;
    private Category category;
    private String description;
    private String make;
    private String model;
    private String type;
    private String watts;
    private String amps;


    protected Audio() {
    }

    protected Audio(Builder value) {

        this._id = value._id;
        this.category = value.category;
        this.description = value.description;
        this.make = value.make;
        this.model = value.model;
        this.type = value.type;
        this.watts = value.watts;
        this.amps = value.amps;

    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getWatts() {
        return watts;
    }

    @Override
    public String getAmps() {
        return amps;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
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
        private String make;
        private String model;
        private String type;
        private String watts;
        private String amps;


        public Builder() {

        }

        public Audio.Builder id(String value) {
            this._id = value;
            return this;
        }

        public Audio.Builder category(Category value) {
            this.category = value;
            return this;
        }

        public Audio.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Audio.Builder productMake(String value) {
            this.make = value;
            return this;
        }

        public Audio.Builder productModel(String value) {
            this.model = value;
            return this;
        }

        public Audio.Builder productType(String value) {
            this.type = value;
            return this;
        }

        public Audio.Builder productWatts(String value) {
            this.watts = value;
            return this;
        }

        public Audio.Builder productAmps(String value) {
            this.amps = value;
            return this;
        }

        public Audio.Builder copy(Audio value) {
            this._id = value._id;
            this.category = value.category;
            this.description = value.description;
            this.make = value.make;
            this.model = value.model;
            this.watts = value.watts;
            this.amps = value.amps;
            this.type = value.type;
            return this;
        }


        public Audio build() {

            return new Audio(this);
        }
    }
}
