package com.velocity.quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public Connection dbConnection(){

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/quiz";
	Connection con = null;
	String uid ="root";
	String pass="root@1234";

		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			con = DriverManager.getConnection(url ,uid ,pass);

		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
}


