package com.example.tpo5.Models;

public class Car {
    String brand, model;
    int year;
    float fuelUsage;

    public Car(float fuelUsage, int year, String model, String brand) {
        this.fuelUsage = fuelUsage;
        this.year = year;
        this.model = model;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public float getFuelUsage() {
        return fuelUsage;
    }
}
