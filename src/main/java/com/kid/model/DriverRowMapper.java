package com.kid.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DriverRowMapper implements RowMapper<Driver> {

    @Override
    public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
	Driver driver = new Driver();
	driver.setId(rs.getInt("id"));
	driver.setEmployeeId(rs.getInt("employee_id"));
	driver.setDriverFrom(rs.getDate("driver_from"));
	driver.setDriverTo(rs.getDate("driver_to"));
	driver.setStatus(rs.getString("status"));
	driver.setActive(rs.getInt("active"));
	driver.setAddedDate(rs.getDate("added_date"));
	driver.setAddedBy(rs.getString("added_by"));
	return driver;
    }

}
