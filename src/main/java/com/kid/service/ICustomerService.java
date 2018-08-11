package com.kid.service;

import java.util.List;

import com.kid.model.Customer;

public interface ICustomerService {

    List<Customer> getAll();
    Customer getCustomerById(int customerId);
    boolean addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
}
