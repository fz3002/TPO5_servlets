package com.example.tpo5.Services;

import com.example.tpo5.Models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListCarsService implements CarsService{
    public static final String PASSWORD = "2137Discombobulated2137";
    public static final String USER = "api_user";
    private static final String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;databaseName=Cars;encrypt=false;trustServerCertificate=true";

    @Override
    public List<Car> getCars(String request) {


        String sqlCommand = "SELECT Cars.Brand, Cars.CarModel, Cars.ProductionYear, Cars.FuelUsage FROM Cars JOIN CarTypes ON Cars.CarTypeID = CarTypes.CarTypeID WHERE CarTypes.TypeName = ?;";
        List <Car> cars = new ArrayList<>();
        try{
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection connection = DriverManager.getConnection(CONNECTIONURL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement(sqlCommand);
            ps.setString(1,request);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String brand = rs.getString("Brand");
                String model = rs.getString("CarModel");
                int productionYear = rs.getInt("ProductionYear");
                float fuelUsage = rs.getFloat("FuelUsage");
                cars.add(new Car(fuelUsage, productionYear, model, brand));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }

    @Override
    public boolean typeExists(String type) {
        String sqlCommand = "SELECT * FROM CarTypes WHERE CarTypes.TypeName = ?;";
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection connection = DriverManager.getConnection(CONNECTIONURL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);

            // Set the car type name parameter
            preparedStatement.setString(1, type);

            // Execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
