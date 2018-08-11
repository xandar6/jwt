package com.kid.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ComboItemRowMapper implements RowMapper<ComboItem> {

    @Override
    public ComboItem mapRow(ResultSet rs, int rowNum) throws SQLException {
	ComboItem combo = new ComboItem();
	combo.setId(rs.getInt("id"));
	combo.setComboName(rs.getString("combo_name"));
	combo.setDefaultQty(rs.getInt("default_qty"));
	combo.setVarient(rs.getString("varient"));
	combo.setTheme(rs.getString("theme"));
	combo.setActive(rs.getInt("active"));
	combo.setAddedDate(rs.getDate("added_date"));
	combo.setAddedBy(rs.getString("added_by"));
	return combo;
    }
}
