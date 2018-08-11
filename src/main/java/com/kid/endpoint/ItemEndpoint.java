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

import com.kid.model.Item;
import com.kid.service.IItemService;

@RestController
@RequestMapping("item")
public class ItemEndpoint {

    @Autowired
    private IItemService itemservice;

    @GetMapping("getall")
    public ResponseEntity<List<Item>> getall() {
	List<Item> list = itemservice.getAll();
	return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") Integer id) {
	Item item = itemservice.getItemById(id);
	return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addItem(@RequestBody Item item, UriComponentsBuilder builder) {

	System.out.println("item add");
	System.out.println(item);
	boolean flag = itemservice.addItem(item);
	if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	HttpHeaders headers = new HttpHeaders();
	headers.setLocation(builder.path("/{id}").buildAndExpand(item.getId()).toUri());
	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {

	System.out.println("item update");
	System.out.println(item);
	itemservice.updateItem(item);
	return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") Integer id) {
	System.out.println("item delete: " + id);
	itemservice.deleteItem(id);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

