package com.kid.dao;

import java.util.List;

import com.kid.model.Item;

public interface IItemDAO {

    List<Item> getAll();
    Item getItemById(int itemId);
    void addItem(Item item);
    void updateItem(Item item);
    void deleteItem(int itemId);
    boolean itemExists(String itemCode);
}
