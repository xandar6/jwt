package com.kid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kid.dao.IComboItemDAO;
import com.kid.dao.IDriverDAO;
import com.kid.model.ComboItem;
import com.kid.model.Driver;

@Service
public class ComboItemService implements IComboItemService {

    @Autowired
    private IComboItemDAO combodao;

    @Override
    public List<ComboItem> getAll() {
	return combodao.getAll();
    }

    @Override
    public ComboItem getComboItemById(int comboItemId) {
	ComboItem obj = combodao.getComboItemById(comboItemId);
	return obj;
    }

    @Override
    public synchronized boolean addComboItem(ComboItem comboItem) {
	if (combodao.comboItemExists(comboItem.getComboName())) {
	    return false;
	} else {
	    combodao.addComboItem(comboItem);
	    return true;
	}
    }

    @Override
    public void updateComboItem(ComboItem comboItem) {
	combodao.updateComboItem(comboItem);
	
    }

    @Override
    public void deleteComboItem(int comboItemId) {
	combodao.deleteComboItem(comboItemId);
	
    }


}
