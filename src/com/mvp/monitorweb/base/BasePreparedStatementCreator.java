package com.mvp.monitorweb.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;

public abstract class BasePreparedStatementCreator<T> implements PreparedStatementCreator {
	
	private T param;
	private String sql;

	public BasePreparedStatementCreator(T param,String sql) {
		this.setParam(param);
		this.setSql(sql);
	}

	
	@Override
	public PreparedStatement createPreparedStatement(Connection conn)
			throws SQLException {
		PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		return update(param,pst);
	}
	
	public abstract PreparedStatement update(T param, PreparedStatement pst) throws SQLException;

	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
}
