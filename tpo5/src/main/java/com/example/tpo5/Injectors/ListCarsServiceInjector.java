package com.example.tpo5.Injectors;

import com.example.tpo5.Consumers.Consumer;
import com.example.tpo5.Consumers.ServiceTask;
import com.example.tpo5.Services.ListCarsService;

public class ListCarsServiceInjector implements CarsServiceInjector{
    @Override
    public Consumer getConsumer() {
        return new ServiceTask(new ListCarsService());
    }
}
