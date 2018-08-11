package com.kid.dao;

import java.util.List;

import com.kid.model.Employee;

public interface IEmployeeDao {

    List<Employee> getAll();
    Employee getEmployeeById(int employeeId);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    boolean employeeExists(String fname, String lname);
}
