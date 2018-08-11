package com.kid.dao;

import java.util.List;

import com.kid.model.Driver;


public interface IDriverDAO {

    List<Driver> getAll();
    Driver getDriverById(int driverId);
    void addDriver(Driver driver);
    void updateDriver(Driver driver);
    void deleteDriver(int driverId);
    boolean driverExists(int driverId);
}
