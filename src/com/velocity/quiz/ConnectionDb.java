package com.velocity.quiz;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
	Connection conection = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/quiz";
	
	public Connection dataBaseConnection() {
		try {
			Class.forName(driver);
			conection = DriverManager.getConnection(url);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conection;
	}

}
