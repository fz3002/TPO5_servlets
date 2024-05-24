package com.example.tpo5.Consumers;

import com.example.tpo5.Exceptions.CarTypeNotFoundException;
import com.example.tpo5.Exceptions.CarsNotFoundException;
import com.example.tpo5.Models.Car;

import java.util.List;

public interface Consumer {
    List<Car> processRequest(String request) throws CarTypeNotFoundException, CarsNotFoundException;
}
