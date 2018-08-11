package com.kid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kid.dao.IDriverDAO;
import com.kid.model.Driver;


@Service
public class DriverService implements IDriverService {
    
    @Autowired
    private IDriverDAO driverdao;

    @Override
    public List<Driver> getAll() {
	return driverdao.getAll();
    }

    @Override
    public Driver getDriverById(int driverId) {
	Driver obj = driverdao.getDriverById(driverId);
	return obj;
    }

    @Override
    public void updateDriver(Driver driver) {
	driverdao.updateDriver(driver);
	
    }

    @Override
    public synchronized boolean addDriver(Driver driver) {
	if (driverdao.driverExists(driver.getEmployeeId())) {
	    return false;
	} else {
	    driverdao.addDriver(driver);
	    return true;
	}
    }

    @Override
    public void deleteDriver(int driverId) {
	driverdao.deleteDriver(driverId);
	
    }

}
