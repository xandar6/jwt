package com.kid.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kid.model.Employee;
import com.kid.service.IEmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeEndpoint {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("getall")
    public ResponseEntity<List<Employee>> getall() {
	List<Employee> list = employeeService.getAll();
	return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
	Employee employee = employeeService.getEmployeeById(id);
	return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee, UriComponentsBuilder builder) {

	System.out.println("employee add");
	System.out.println(employee);
	boolean flag = employeeService.addEmployee(employee);
	if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	HttpHeaders headers = new HttpHeaders();
	headers.setLocation(builder.path("/{id}").buildAndExpand(employee.getId()).toUri());
	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

	System.out.println("employee update");
	System.out.println(employee);
	employeeService.updateEmployee(employee);
	return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
	System.out.println("employee delete: " + id);
	employeeService.deleteEmployee(id);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
