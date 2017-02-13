package com.fimelab.reman.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbManagement implements IDbManagement {

	private static DbManagement instance = new DbManagement();
	private ADbManagement delegate;
	
	private DbManagement() {
		
	}
	
	public static DbManagement getInstance() {
		return instance;
	}
	
	public void setDelegate(ADbManagement delegate) {
		this.delegate = delegate;
	}

	@Override
	public void connection(String bdd_path) throws SQLException {
		delegate.connection(bdd_path);
	}

	@Override
	public void disconnection() throws SQLException {
		delegate.disconnection();
	}

	@Override
	public ResultSet query(String queryString) throws SQLException {
		return delegate.query(queryString);
	}

	@Override
	public int update(String queryString) throws SQLException {
		return delegate.update(queryString);
	}
}
