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

import com.kid.model.ComboItem;
import com.kid.service.IComboItemService;

@RestController
@RequestMapping("combo_item")
public class ComboItemEndpoint {

    @Autowired
    private IComboItemService comboservice;

    @GetMapping("getall")
    public ResponseEntity<List<ComboItem>> getall() {
	List<ComboItem> list = comboservice.getAll();
	return new ResponseEntity<List<ComboItem>>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ComboItem> getComboItemById(@PathVariable("id") Integer id) {
	ComboItem combo = comboservice.getComboItemById(id);
	return new ResponseEntity<ComboItem>(combo, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addComboItem(@RequestBody ComboItem combo, UriComponentsBuilder builder) {

	System.out.println("combo item add");
	System.out.println(combo);
	boolean flag = comboservice.addComboItem(combo);
	if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	HttpHeaders headers = new HttpHeaders();
	headers.setLocation(builder.path("/{id}").buildAndExpand(combo.getId()).toUri());
	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<ComboItem> updateComboItem(@RequestBody ComboItem combo) {

	System.out.println("combo item update");
	System.out.println(combo);
	comboservice.updateComboItem(combo);
	return new ResponseEntity<ComboItem>(combo, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteComboItem(@PathVariable("id") Integer id) {
	System.out.println("combo item delete: " + id);
	comboservice.deleteComboItem(id);
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

