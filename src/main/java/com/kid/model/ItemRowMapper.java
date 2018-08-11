package com.kid.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
	Item item = new Item();
	item.setId(rs.getInt("id"));
	item.setItemCode(rs.getString("item_code"));
	item.setItemName(rs.getString("item_name"));
	item.setItemDesc(rs.getString("item_desc"));
	item.setItemType(rs.getString("item_type"));
	item.setAmount(rs.getInt("amount"));
	item.setCost(rs.getDouble("cost"));
	item.setPrice(rs.getDouble("price"));
	item.setStatus(rs.getString("status"));
	item.setColor(rs.getString("color"));
	item.setActive(rs.getInt("active"));
	item.setAddedDate(rs.getDate("added_date"));
	item.setAddedBy(rs.getString("added_by"));
	return item;
    }

}
