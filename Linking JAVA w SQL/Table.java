package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {
	//JDBC Driver address
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//DB Access Address
	static final String DB_URL = "jdbc:mysql://localhost:3306/java?useSSL=False";
	
	//Username and Password of SQL
	static final String username = "root";
	static final String password = "richard";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.print("Access to user table : ");
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,username,password);
			if(conn != null) {
				System.out.println("Success !");
			}
			else {
				System.out.println("Fail");
			}
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exception");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("SQL Exception : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
