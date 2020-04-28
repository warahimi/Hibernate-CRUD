package JDBC;

import java.sql.*;

public class JDBCConnection {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/test?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		//we can use the above information to get a conncetion to our database
		
		
		try {
			System.out.println("Connect to Database: "+ jdbcURL);
			Connection myCon = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connected Sucessfully ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
