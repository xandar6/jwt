package com.kid.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kid.model.Item;
import com.kid.model.ItemRowMapper;

@Transactional
@Repository
public class ItemDAO implements IItemDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemDAO(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Item> getAll() {
	String sql = "SELECT id, item_code, item_name, item_desc, item_type, amount, cost, price, status, color, active, added_date, added_by  FROM item";
	RowMapper<Item> rowMapper = new ItemRowMapper();
	return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Item getItemById(int itemId) {
	String sql = "SELECT id, item_code, item_name, item_desc, item_type, amount, cost, price, status, color, active, added_date, added_by  FROM item WHERE id = ?";
	RowMapper<Item> rowMapper = new BeanPropertyRowMapper<Item>(Item.class);
	Item item = jdbcTemplate.queryForObject(sql, rowMapper, itemId);
	return item;
    }

    @Override
    public void addItem(Item item) {
	String sql = "INSERT INTO item (item_code, item_name, item_desc, item_type, amount, cost, price, status, color) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	jdbcTemplate.update(sql, 
		item.getItemCode(),
		item.getItemName(),
		item.getItemDesc(),
		item.getItemType(),
		item.getAmount(),
		item.getCost(),
		item.getPrice(),
		item.getStatus(),
		item.getColor()
		);
	
    }

    @Override
    public void updateItem(Item item) {
	String sql = "UPDATE item SET item_code = ?, item_name = ?, item_desc = ?, item_type = ?, amount = ?, cost = ?, price = ?, status = ?, color = ?, active = ? WHERE id = ?";
	jdbcTemplate.update(sql, 
		item.getItemCode(),
		item.getItemName(),
		item.getItemDesc(),
		item.getItemType(),
		item.getAmount(),
		item.getCost(),
		item.getPrice(),
		item.getStatus(),
		item.getColor(),
		item.getActive(),
		item.getId()
		);
	
    }

    @Override
    public void deleteItem(int itemId) {
	String sql = "DELETE FROM item WHERE id = ?";
	jdbcTemplate.update(sql, itemId);
	
    }

    @Override
    public boolean itemExists(String itemCode) {
	String sql = "SELECT count(*) FROM item WHERE item_code = ?";
	int count = jdbcTemplate.queryForObject(sql, Integer.class, itemCode);
	if (count == 0) {
	    return false;
	} else {
	    System.out.println("item already exists");
	    return true;
	}
    }
}
