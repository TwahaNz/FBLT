package FBLT.domain.product.vehicle;

import FBLT.domain.product.category.Category;

/**
 * Created by kraluk01 on 9/23/2016.
 */
public class Vehicle implements IVehicle {

    private Long productId;
    private Category category;
    private String description;
    private String type;
    private String make;
    private String model;
    private String year;
    private String fuel;
    private String transmission;


    private Vehicle(){}

    private Vehicle(Builder value){

        this.productId = value.productId;
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

    @Override
    public Long getProductId() {
        return productId;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String getProductDescription() {
        return description;
    }

    public static class Builder {

        private Long productId;
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

        public Vehicle.Builder productID(Long value) {
            this.productId = value;
            return this;
        }

        public Vehicle.Builder category(Category value) {
            this.category= value;
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
            this.productId = value.productId;
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
