package com.kid.service;

import java.util.List;

import com.kid.model.Driver;



public interface IDriverService {

    List<Driver> getAll();
    Driver getDriverById(int driverId);
    void updateDriver(Driver driver);
    boolean addDriver(Driver driver);
    void deleteDriver(int driverId);
}
