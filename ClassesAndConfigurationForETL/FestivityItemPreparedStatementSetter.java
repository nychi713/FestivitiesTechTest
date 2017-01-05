package com.testbazurton.spring;

import com.testbazurton.spring.model.Festivity;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;


public class FestivityItemPreparedStatementSetter implements ItemPreparedStatementSetter<Festivity> {

	public void setValues(Festivity result, PreparedStatement ps) throws SQLException {
		ps.setInt(1, result.getId());
                ps.setString(2, result.getName());
		ps.setDate(3, new java.sql.Date(result.getStartDate().toDate().getTime()));
                ps.setDate(4, new java.sql.Date(result.getEndDate().toDate().getTime()));
		ps.setString(5, result.getPlace());
	}

}