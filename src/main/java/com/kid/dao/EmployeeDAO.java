package com.kid.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kid.model.Employee;
import com.kid.model.EmployeeRowMapper;

@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDao {

    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }
    

    
    @Override
    public List<Employee> getAll() {
	String sql = "SELECT id, fname, lname, address, mobile, tel, nic, email, designation, joined_date, left_date, active, remarks, added_date, added_by  FROM employee";
	// RowMapper<Article> rowMapper = new
	// BeanPropertyRowMapper<Article>(Article.class);
	RowMapper<Employee> rowMapper = new EmployeeRowMapper();
	return this.jdbcTemplate.query(sql, rowMapper);
    }
    
    

    @Override
    public Employee getEmployeeById(int employeeId) {
	String sql = "SELECT id, fname, lname, address, mobile, tel, nic, email, designation, joined_date, left_date, active, remarks, added_date, added_by  FROM employee WHERE id = ?";
	RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
	Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, employeeId);
	return employee;
    }
    
    

    @Override
    public void addEmployee(Employee employee) {
	// Add employee
	String sql = "INSERT INTO employee (fname, lname, address, mobile, tel, nic, email, designation, joined_date, left_date, remarks) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	jdbcTemplate.update(sql, 
		employee.getFname(), 
		employee.getLname(), 
		employee.getAddedBy(), 
		employee.getMobile(), 
		employee.getTel(), 
		employee.getNic(), 
		employee.getEmail(), 
		employee.getDesignation(), 
		employee.getJoinedDate(), 
		employee.getLeftDate(), 
		employee.getRemarks()
		);
//	System.out.println("");
	
//	// Fetch article id
//	sql = "SELECT id FROM employee WHERE fname = ? and lname=?";
//	int employeeId = jdbcTemplate.queryForObject(sql, Integer.class, employee.getFname(), employee.getLeftDate());
//
//	// Set article id
//	employee.setId(employeeId);

    }
    
    

    @Override
    public boolean employeeExists(String fname, String lname) {
	String sql = "SELECT count(*) FROM employee WHERE fname = ? and lname = ?";
	int count = jdbcTemplate.queryForObject(sql, Integer.class, fname, lname);
	if (count == 0) {
	    return false;
	} else {
	    System.out.println("employee already exists");
	    return true;
	}
    }
    
    

    @Override
    public void updateEmployee(Employee employee) {
	String sql = "UPDATE employee SET fname = ?, lname = ?, address = ?, mobile = ?, tel = ?, nic = ?, email = ?, designation = ?, joined_date = ?, left_date = ?, active = ?, remarks = ? WHERE id = ?";
	jdbcTemplate.update(sql, 
		employee.getFname(), 
		employee.getLname(), 
		employee.getAddedBy(), 
		employee.getMobile(), 
		employee.getTel(), 
		employee.getNic(), 
		employee.getEmail(), 
		employee.getDesignation(), 
		employee.getJoinedDate(), 
		employee.getLeftDate(), 
		employee.getActive(),
		employee.getRemarks(),
		employee.getId()
		);
	
    }



    @Override
    public void deleteEmployee(int employeeId) {
	String sql = "DELETE FROM employee WHERE id = ?";
	jdbcTemplate.update(sql, employeeId);
	
    }
    
    

}
