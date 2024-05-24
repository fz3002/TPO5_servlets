package com.example.tpo5.Servlets;

import com.example.tpo5.Consumers.Consumer;
import com.example.tpo5.Consumers.ServiceTask;
import com.example.tpo5.Exceptions.CarTypeNotFoundException;
import com.example.tpo5.Exceptions.CarsNotFoundException;
import com.example.tpo5.Injectors.CarsServiceInjector;
import com.example.tpo5.Injectors.ListCarsServiceInjector;
import com.example.tpo5.Models.Car;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DataServlet", value = "/cars/data")
public class DataServlet extends HttpServlet {
    CarsServiceInjector injector = null;
    Consumer task = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Dependency injection
        injector = new ListCarsServiceInjector();
        task = injector.getConsumer();

        String carType = request.getParameter("carType");
        List<Car> cars;
        try {
            cars = task.processRequest(carType);
        } catch (CarTypeNotFoundException | CarsNotFoundException e) {
            throw new ServletException(e);
        }

        Gson gson = new Gson();
        String jsonCars = gson.toJson(cars);
        System.out.println(jsonCars);
        request.setAttribute("carsList", jsonCars);
        getServletContext().getRequestDispatcher("/cars/result").include(request, response);
    }
}