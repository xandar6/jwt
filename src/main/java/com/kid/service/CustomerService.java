package com.kid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kid.dao.ICustomerDAO;
import com.kid.dao.IDriverDAO;
import com.kid.model.Customer;
import com.kid.model.Driver;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerDAO cusdao;

    @Override
    public List<Customer> getAll() {
	return cusdao.getAll();
    }

    @Override
    public Customer getCustomerById(int customerId) {
	Customer obj = cusdao.getCustomerById(customerId);
	return obj;
    }

    @Override
    public synchronized boolean addCustomer(Customer customer) {
	if (cusdao.customerExists(customer.getName())) {
	    return false;
	} else {
	    cusdao.addCustomer(customer);
	    return true;
	}
    }

    @Override
    public void updateCustomer(Customer customer) {
	cusdao.updateCustomer(customer);
	
    }

    @Override
    public void deleteCustomer(int customerId) {
	cusdao.deleteCustomer(customerId);
	
    }
}
