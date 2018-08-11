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

import com.kid.model.Customer;
import com.kid.service.ICustomerService;

@RestController
@RequestMapping("customer")
public class CustomerEndpoint {

    @Autowired
    private ICustomerService customerservice;

    @GetMapping("getall")
    public ResponseEntity<List<Customer>> getall() {
	List<Customer> list = customerservice.getAll();
	return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
	Customer combo = customerservice.getCustomerById(id);
	return new ResponseEntity<Customer>(combo, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addCustomer(@RequestBody Customer combo, UriComponentsBuilder builder) {

	System.out.println("combo item add");
	System.out.println(combo);
	boolean flag = customerservice.addCustomer(combo);
	if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	HttpHeaders headers = new HttpHeaders();
	headers.setLocation(builder.path("/{id}").buildAndExpand(combo.getId()).toUri());
	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer combo) {

	System.out.println("combo item update");
	System.out.println(combo);
	customerservice.updateCustomer(combo);
	return new ResponseEntity<Customer>(combo, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id) {
	System.out.println("combo item delete: " + id);
	customerservice.deleteCustomer(id);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
