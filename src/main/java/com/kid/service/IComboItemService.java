package com.kid.service;

import java.util.List;

import com.kid.model.ComboItem;

public interface IComboItemService {

    List<ComboItem> getAll();
    ComboItem getComboItemById(int comboItemId);
    boolean addComboItem(ComboItem comboItem);
    void updateComboItem(ComboItem comboItem);
    void deleteComboItem(int comboItemId);
}
