package com.kid.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kid.model.Driver;
import com.kid.model.DriverRowMapper;


@Transactional
@Repository
public class DriverDAO implements IDriverDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DriverDAO(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<Driver> getAll() {
	String sql = "SELECT id, employee_id, driver_from, driver_to, status, active, added_date, added_by FROM driver";
	RowMapper<Driver> rowMapper = new DriverRowMapper();
	return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Driver getDriverById(int driverId) {
	String sql = "SELECT id, employee_id, driver_from, driver_to, status, active, added_date, added_by FROM driver WHERE id = ?";
	RowMapper<Driver> rowMapper = new BeanPropertyRowMapper<Driver>(Driver.class);
	Driver driver = jdbcTemplate.queryForObject(sql, rowMapper, driverId);
	return driver;
    }

    @Override
    public void addDriver(Driver driver) {
	String sql = "INSERT INTO driver (employee_id, driver_from, driver_to, status) values (?, ?, ?, ?)";
	jdbcTemplate.update(sql, 
		driver.getEmployeeId(),
		driver.getDriverFrom(),
		driver.getDriverTo(),
		driver.getStatus()
		);
	
    }

    @Override
    public void updateDriver(Driver driver) {
	String sql = "UPDATE driver SET driver_from = ?, driver_to = ?, status = ?, active = ? WHERE id = ?";
	jdbcTemplate.update(sql, 
		driver.getDriverFrom(),
		driver.getDriverTo(),
		driver.getStatus(),
		driver.getActive()
		);
	
    }

    @Override
    public void deleteDriver(int driverId) {
	String sql = "DELETE FROM driver WHERE id = ?";
	jdbcTemplate.update(sql, driverId);
	
    }

    @Override
    public boolean driverExists(int employeeId) {
	String sql = "SELECT count(*) FROM driver WHERE employee_id = ?";
	int count = jdbcTemplate.queryForObject(sql, Integer.class, employeeId);
	if (count == 0) {
	    return false;
	} else {
	    System.out.println("driver already exists");
	    return true;
	}
    }

}
