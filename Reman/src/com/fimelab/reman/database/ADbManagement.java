package com.fimelab.reman.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ADbManagement implements IDbManagement {
	//final String User = "jeremie", Password = "jeremie";
    final String User = "reman", Password = "jdbcaccesspoint";
	Connection conn;

	@Override
	public void disconnection() throws SQLException {
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace(System.err);
		}
	}

	@Override
	public ResultSet query(String queryString) throws SQLException {
        return conn.createStatement().executeQuery(queryString);
	}

	@Override
	public int update(String queryString) throws SQLException {
		return conn.createStatement().executeUpdate(queryString);
	}
}
