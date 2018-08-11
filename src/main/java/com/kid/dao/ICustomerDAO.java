package com.kid.dao;

import java.util.List;

import com.kid.model.Customer;



public interface ICustomerDAO {

    List<Customer> getAll();
    Customer getCustomerById(int customerId);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
    boolean customerExists(String name);
}
