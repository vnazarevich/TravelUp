package com.epam.travelup.orm.persistant;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionManager {
	private static ComboPooledDataSource cpds;
	static {
		cpds = new ComboPooledDataSource(); 
		try {
			cpds.setDriverClass( "com.mysql.jdbc.Driver" );
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/toursite_database?useUnicode=true&characterEncoding=UTF-8" ); 
		cpds.setUser("root"); 
		cpds.setPassword("root"); 
		
	}

	public synchronized static Connection getConnection() {
		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}