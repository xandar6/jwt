package com.kid.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kid.model.ComboItem;
import com.kid.model.ComboItemRowMapper;



@Transactional
@Repository
public class ComboItemDAO implements IComboItemDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ComboItemDAO(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ComboItem> getAll() {
	String sql = "SELECT id, combo_name, combo_desc, default_qty, varient, theme, active, added_date, added_by FROM prod_combo";
	RowMapper<ComboItem> rowMapper = new ComboItemRowMapper();
	return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public ComboItem getComboItemById(int comboItemId) {
	String sql = "SELECT id, combo_name, combo_desc, default_qty, varient, theme, active, added_date, added_by FROM prod_combo WHERE id = ?";
	RowMapper<ComboItem> rowMapper = new BeanPropertyRowMapper<ComboItem>(ComboItem.class);
	ComboItem combo = jdbcTemplate.queryForObject(sql, rowMapper, comboItemId);
	return combo;
    }

    @Override
    public void addComboItem(ComboItem comboItem) {
	String sql = "INSERT INTO prod_combo (combo_name, combo_desc, default_qty, varient, theme) values (?, ?, ?, ?, ?)";
	jdbcTemplate.update(sql, 
		comboItem.getComboName(),
		comboItem.getComboDesc(),
		comboItem.getDefaultQty(),
		comboItem.getVarient(),
		comboItem.getTheme()
		);
	
    }

    @Override
    public void updateComboItem(ComboItem comboItem) {
	String sql = "UPDATE prod_combo SET combo_name = ?, combo_desc = ?, default_qty = ?, varient = ?, theme = ?, active = ? WHERE id = ?";
	jdbcTemplate.update(sql, 
		comboItem.getComboName(),
		comboItem.getComboDesc(),
		comboItem.getDefaultQty(),
		comboItem.getVarient(),
		comboItem.getTheme(),
		comboItem.getActive(),
		comboItem.getId()
		);
	
    }

    @Override
    public void deleteComboItem(int comboItemId) {
	String sql = "DELETE FROM prod_combo WHERE id = ?";
	jdbcTemplate.update(sql, comboItemId);
	
    }

    @Override
    public boolean comboItemExists(String comboName) {
	String sql = "SELECT count(*) FROM prod_combo WHERE combo_name = ?";
	int count = jdbcTemplate.queryForObject(sql, Integer.class, comboName);
	if (count == 0) {
	    return false;
	} else {
	    System.out.println("combo item already exists");
	    return true;
	}
    }
}
