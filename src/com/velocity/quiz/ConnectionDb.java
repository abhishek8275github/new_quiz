package com.velocity.quiz;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
	Connection con = null;
	
	public Connection dataBaseConnection() {
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/quiz";
	String uid ="root";
	String pass="Abhishek 8275";
	
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, pass);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}