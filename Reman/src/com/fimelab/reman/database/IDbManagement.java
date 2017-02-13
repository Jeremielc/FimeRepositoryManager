package com.fimelab.reman.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbManagement {

	void connection(String bdd_path) throws SQLException;
	void disconnection() throws SQLException;
	ResultSet query(String queryString) throws SQLException;
	int update(String queryString) throws  SQLException;
}
