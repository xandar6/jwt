package com.kid.service;

import java.util.List;

import com.kid.model.Employee;

public interface IEmployeeService {

    List<Employee> getAll();
    Employee getEmployeeById(int employeeId);
    void updateEmployee(Employee employee);
    boolean addEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}
