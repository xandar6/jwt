package com.kid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kid.dao.IItemDAO;
import com.kid.model.Employee;
import com.kid.model.Item;

@Service
public class ItemService implements IItemService {

    @Autowired
    private IItemDAO itemdao;

    @Override
    public List<Item> getAll() {
	return itemdao.getAll();
    }

    @Override
    public Item getItemById(int itemId) {
	Item obj = itemdao.getItemById(itemId);
	return obj;
    }

    @Override
    public void updateItem(Item item) {
	itemdao.updateItem(item);
	
    }

    @Override
    public synchronized boolean addItem(Item item) {
	if (itemdao.itemExists(item.getItemCode())) {
	    return false;
	} else {
	    itemdao.addItem(item);
	    return true;
	}
    }

    @Override
    public void deleteItem(int itemId) {
	itemdao.deleteItem(itemId);
	
    }
}
