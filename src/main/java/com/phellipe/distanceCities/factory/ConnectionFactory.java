package com.phellipe.distanceCities.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {

		try {
			String driveName = "com.mysql.jdbc.Driver";
			Class.forName(driveName);

			String serverName = "localhost";
			String dataBase = "project";
			String port = "3306";
			String url = "jdbc:mysql://" + serverName + ":" + port + "/" + dataBase;
			String username = "root";
			String password = "root";
			
            return DriverManager.getConnection(url, username, password);


		} catch (Exception e) {
			return null;
		}

	}
	
	  public static boolean closeConnection() {

	        try {
	            ConnectionFactory.getConnection().close();
	            return true;

	        } catch (SQLException e) {
	            return false;
	        }

	    }

}
