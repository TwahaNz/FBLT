package FBLT.domain.product.vehicle;

import FBLT.domain.product.category.Category;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public class Vehicle implements IVehicle {

    private String _id;
    private Category category;
    private String description;
    private String type;
    private String make;
    private String model;
    private String year;
    private String fuel;
    private String transmission;


    protected Vehicle() {
    }

    private Vehicle(Builder value) {

        this._id = value._id;
        this.category = value.category;
        this.description = value.description;
        this.type = value.type;
        this.make = value.make;
        this.model = value.model;
        this.year = value.year;
        this.fuel = value.fuel;
        this.transmission = value.transmission;

    }

    @Override
    public String getVehicletype() {
        return type;
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
    public String getYear() {
        return year;
    }

    @Override
    public String getFuelType() {
        return fuel;
    }

    @Override
    public String getTransmissionType() {
        return transmission;
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
        private String make;
        private String model;
        private String year;
        private String fuel;
        private String transmission;


        public Builder() {

        }

        public Vehicle.Builder id(String value) {
            this._id = value;
            return this;
        }

        public Vehicle.Builder category(Category value) {
            this.category = value;
            return this;
        }

        public Vehicle.Builder productDescription(String value) {
            this.description = value;
            return this;
        }

        public Vehicle.Builder productType(String value) {
            this.type = value;
            return this;
        }

        public Vehicle.Builder productMake(String value) {
            this.make = value;
            return this;
        }

        public Vehicle.Builder productModel(String value) {
            this.model = value;
            return this;
        }

        public Vehicle.Builder productYear(String value) {
            this.year = value;
            return this;
        }

        public Vehicle.Builder productFuel(String value) {
            this.fuel = value;
            return this;
        }

        public Vehicle.Builder productTransmission(String value) {
            this.transmission = value;
            return this;
        }

        public Vehicle.Builder copy(Vehicle value) {
            this._id = value._id;
            this.category = value.category;
            this.description = value.description;
            this.type = value.type;
            this.make = value.make;
            this.model = value.model;
            this.year = value.year;
            this.fuel = value.fuel;
            this.transmission = value.transmission;
            return this;
        }

        public Vehicle build() {

            return new Vehicle(this);
        }
    }

}
