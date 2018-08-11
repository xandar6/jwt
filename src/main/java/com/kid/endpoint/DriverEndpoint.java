package com.kid.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kid.model.Driver;
import com.kid.service.IDriverService;

@RestController
@RequestMapping("driver")
public class DriverEndpoint {

    @Autowired
    private IDriverService driverService;

    @GetMapping("getall")
    public ResponseEntity<List<Driver>> getall() {
	List<Driver> list = driverService.getAll();
	return new ResponseEntity<List<Driver>>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable("id") Integer id) {
	Driver driver = driverService.getDriverById(id);
	return new ResponseEntity<Driver>(driver, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addDriver(@RequestBody Driver driver, UriComponentsBuilder builder) {

	System.out.println("driver add");
	System.out.println(driver);
	boolean flag = driverService.addDriver(driver);
	if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	HttpHeaders headers = new HttpHeaders();
	headers.setLocation(builder.path("/{id}").buildAndExpand(driver.getId()).toUri());
	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) {

	System.out.println("driver update");
	System.out.println(driver);
	driverService.updateDriver(driver);
	return new ResponseEntity<Driver>(driver, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable("id") Integer id) {
	System.out.println("driver delete: " + id);
	driverService.deleteDriver(id);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

