package com.example.tpo5.Consumers;

import com.example.tpo5.Exceptions.CarTypeNotFoundException;
import com.example.tpo5.Exceptions.CarsNotFoundException;
import com.example.tpo5.Models.Car;
import com.example.tpo5.Services.CarsService;

import java.util.List;

public class ServiceTask implements Consumer{
    private final CarsService service;

    public ServiceTask(CarsService service) {
        this.service = service;
    }
    @Override
    public List<Car> processRequest(String type) throws CarTypeNotFoundException, CarsNotFoundException {
        boolean typeExists = this.service.typeExists(type);
        if (!typeExists) throw new CarTypeNotFoundException("Car type not found in database");
        List<Car> cars = this.service.getCars(type);
        if (cars.isEmpty()) throw new CarsNotFoundException("Cars of this type not found in database");
        return cars;
    }
}
