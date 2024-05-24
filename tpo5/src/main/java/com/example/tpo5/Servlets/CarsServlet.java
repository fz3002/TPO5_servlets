package com.example.tpo5.Servlets;

import com.example.tpo5.Models.Car;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CarsServlet", value = "/cars/result")
public class CarsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String jsonCars = (String) request.getAttribute("carsList");
        System.out.println(jsonCars);
        Gson gson = new Gson();
        Car[] cars = gson.fromJson(jsonCars, Car[].class);
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<table border=\"1\">");

        // Table header
        out.println("<tr>");
        out.println("<th>Make</th>");
        out.println("<th>Model</th>");
        out.println("<th>Year</th>");
        out.println("<th>Fuel Usage</th>");
        out.println("</tr>");

        // Table rows
        for (Car car : cars) {
            out.println("<tr>");
            out.println("<td>" + car.getBrand() + "</td>");
            out.println("<td>" + car.getModel() + "</td>");
            out.println("<td>" + car.getYear() + "</td>");
            out.println("<td>" + car.getFuelUsage() + "</td>");
            out.println("</tr>");
        }

        // End of HTML table
        out.println("</table>");
    }
}