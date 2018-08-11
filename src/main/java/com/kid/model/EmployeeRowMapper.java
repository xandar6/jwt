package com.kid.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
	Employee employee = new Employee();
	employee.setId(row.getInt("id"));
	employee.setFname(row.getString("fname"));
	employee.setLname(row.getString("lname"));
	employee.setAddedBy(row.getString("address"));
	employee.setMobile(row.getString("mobile"));
	employee.setTel(row.getString("tel"));
	employee.setNic(row.getString("nic"));
	employee.setEmail(row.getString("email"));
	employee.setDesignation(row.getString("designation"));
	employee.setJoinedDate(row.getDate("joined_date"));
	employee.setLeftDate(row.getDate("left_date"));
	employee.setActive(row.getInt("active"));
	employee.setRemarks(row.getString("remarks"));
	employee.setAddedDate(row.getDate("added_date"));
	employee.setAddedBy(row.getString("added_by"));

	
	return employee;
    }

}
