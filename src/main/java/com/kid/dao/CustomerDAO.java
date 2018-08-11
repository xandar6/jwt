package com.kid.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kid.model.Customer;
import com.kid.model.CustomerRowMapper;
import com.kid.model.Driver;
import com.kid.model.DriverRowMapper;

@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDAO(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> getAll() {
	String sql = "SELECT id, `name`, address, mobile1, mobile2, tel_home, tel_office, email, remarks, active, added_date, added_by FROM customer";
	RowMapper<Customer> rowMapper = new CustomerRowMapper();
	return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Customer getCustomerById(int customerId) {
	String sql = "SELECT id, `name`, address, mobile1, mobile2, tel_home, tel_office, email, remarks, active, added_date, added_by FROM customer WHERE id = ?";
	RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<Customer>(Customer.class);
	Customer cus = jdbcTemplate.queryForObject(sql, rowMapper, customerId);
	return cus;
    }

    @Override
    public void addCustomer(Customer customer) {
	String sql = "INSERT INTO customer (`name`, address, mobile1, mobile2, tel_home, tel_office, email, remarks) values (?, ?, ?, ?, ?, ?, ?, ?)";
	jdbcTemplate.update(sql, 
		customer.getName(),
		customer.getAddedBy(),
		customer.getMobile1(),
		customer.getMobile2(),
		customer.getTelHome(),
		customer.getTelOffice(),
		customer.getEmail(),
		customer.getRemarks()
		);
	
    }

    @Override
    public void updateCustomer(Customer customer) {
	String sql = "UPDATE customer SET `name` = ?, address = ?, mobile1 = ?, mobile2 = ?, tel_home = ?, tel_office = ?, email = ?, remarks = ?, active = ? WHERE id = ?";
	jdbcTemplate.update(sql, 
		customer.getName(),
		customer.getAddedBy(),
		customer.getMobile1(),
		customer.getMobile2(),
		customer.getTelHome(),
		customer.getTelOffice(),
		customer.getEmail(),
		customer.getRemarks(),
		customer.getActive(),
		customer.getId()
		);
	
    }

    @Override
    public void deleteCustomer(int customerId) {
	String sql = "DELETE FROM customer WHERE id = ?";
	jdbcTemplate.update(sql, customerId);
	
    }

    @Override
    public boolean customerExists(String name) {
	String sql = "SELECT count(*) FROM customer WHERE name = ?";
	int count = jdbcTemplate.queryForObject(sql, Integer.class, name);
	if (count == 0) {
	    return false;
	} else {
	    System.out.println("customer already exists");
	    return true;
	}
    }
    
    
}
