package model;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private Type type;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private String vinNumber;
    private static final long serialVersionUID = 6433858223774886977L;

    public Vehicle(Type type, String brand, String model, int year, int mileage, String vinNumber) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.vinNumber = vinNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    @Override
    public String toString() {
        return type + ", " + brand + ", " + model + ", " + year + ", przebieg: " + mileage + " km, VIN: " + vinNumber;
    }
}
