package com.kid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kid.dao.IEmployeeDao;
import com.kid.model.Employee;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    public List<Employee> getAll() {
	return employeeDao.getAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
	Employee obj = employeeDao.getEmployeeById(employeeId);
	return obj;
    }

    @Override
    public synchronized boolean addEmployee(Employee employee) {
	if (employeeDao.employeeExists(employee.getFname(), employee.getLname())) {
	    return false;
	} else {
	    employeeDao.addEmployee(employee);
	    return true;
	}

    }

    @Override
    public void updateEmployee(Employee employee) {
	employeeDao.updateEmployee(employee);
	
    }

    @Override
    public void deleteEmployee(int employeeId) {
	employeeDao.deleteEmployee(employeeId);
	
    }

}
