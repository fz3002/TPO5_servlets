CREATE DATABASE Cars
USE Cars
-- Create the CarTypes table
CREATE TABLE CarTypes (
                          CarTypeID INT PRIMARY KEY IDENTITY(1,1),
                          TypeName VARCHAR(50) NOT NULL
);

-- Create the Cars table with the updated CarModel column and additional information
CREATE TABLE Cars (
                      CarID INT PRIMARY KEY IDENTITY(1,1),
                      CarModel VARCHAR(100) NOT NULL,
                      Brand VARCHAR(50) NOT NULL,
                      ProductionYear INT NOT NULL,
                      FuelUsage DECIMAL(5, 2) NOT NULL, -- Fuel usage in liters per 100 km
                      CarTypeID INT,
                      CONSTRAINT FK_CarTypes FOREIGN KEY (CarTypeID) REFERENCES CarTypes(CarTypeID)
);

-- Insert sample data into CarTypes table
INSERT INTO CarTypes (TypeName) VALUES ('SUV');
INSERT INTO CarTypes (TypeName) VALUES ('Sedan');
INSERT INTO CarTypes (TypeName) VALUES ('Truck');
INSERT INTO CarTypes (TypeName) VALUES ('Coupe');
INSERT INTO CarTypes (TypeName) VALUES ('Convertible');

-- Insert sample data into Cars table
INSERT INTO Cars (CarModel, Brand, ProductionYear, FuelUsage, CarTypeID) VALUES ('Camry', 'Toyota', 2020, 7.8, 2);
INSERT INTO Cars (CarModel, Brand, ProductionYear, FuelUsage, CarTypeID) VALUES ('F-150', 'Ford', 2019, 10.5, 3);
INSERT INTO Cars (CarModel, Brand, ProductionYear, FuelUsage, CarTypeID) VALUES ('Civic', 'Honda', 2021, 6.5, 2);
INSERT INTO Cars (CarModel, Brand, ProductionYear, FuelUsage, CarTypeID) VALUES ('Model S', 'Tesla', 2022, 0, 4); -- Electric car, hence fuel usage is 0
INSERT INTO Cars (CarModel, Brand, ProductionYear, FuelUsage, CarTypeID) VALUES ('Mustang', 'Ford', 2020, 9.5, 4);