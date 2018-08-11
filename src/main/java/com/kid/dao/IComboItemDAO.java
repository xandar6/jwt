package com.kid.dao;

import java.util.List;

import com.kid.model.ComboItem;


public interface IComboItemDAO {

    List<ComboItem> getAll();
    ComboItem getComboItemById(int comboItemId);
    void addComboItem(ComboItem comboItem);
    void updateComboItem(ComboItem comboItem);
    void deleteComboItem(int comboItemId);
    boolean comboItemExists(String comboItemId);
}
