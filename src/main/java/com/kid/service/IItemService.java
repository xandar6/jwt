package com.kid.service;

import java.util.List;

import com.kid.model.Item;


public interface IItemService {
    List<Item> getAll();
    Item getItemById(int itemId);
    void updateItem(Item item);
    boolean addItem(Item item);
    void deleteItem(int itemId);
}
