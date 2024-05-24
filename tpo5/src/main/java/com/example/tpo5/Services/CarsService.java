package com.example.tpo5.Services;

import com.example.tpo5.Models.Car;

import java.util.List;

public interface CarsService {
    public List<Car> getCars(String request);
    boolean typeExists(String type);
}
