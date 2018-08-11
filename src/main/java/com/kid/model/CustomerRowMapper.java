package com.kid.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer>{

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	Customer cus = new Customer();
	cus.setId(rs.getInt("id"));
	cus.setName(rs.getString("name"));
	cus.setAddress(rs.getString("address"));
	cus.setMobile1(rs.getString("mobile1"));
	cus.setMobile2(rs.getString("mobile2"));
	cus.setTelHome(rs.getString("tel_home"));
	cus.setTelOffice(rs.getString("tel_office"));
	cus.setEmail(rs.getString("email"));
	cus.setRemarks(rs.getString("remarks"));
	cus.setActive(rs.getInt("active"));
	cus.setAddedDate(rs.getDate("added_date"));
	cus.setAddedBy(rs.getString("added_by"));
	return cus;
    }

}
