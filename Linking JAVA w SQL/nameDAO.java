package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class nameDAO {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/java?useSSL=False";
	
	static final String username = "root";
	static final String password = "richard";
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public nameDAO() {
		System.out.print("Access to Database : ");
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, username, password);
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
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
	}
	
	
	public void tableInsert(int No, String Name) {
		name n = new name(No, Name);
		String query = "Insert into name " + "Value (" + n.No +", '" + n.Name + "');";
		System.out.println(query);
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, username, password);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			conn.close();
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exception");
		}
		catch (SQLException e) {
			System.out.println("SQL Exception" + e.getMessage());
		}
	}
	
	public void tableSelect() {
		String query = "SELECT * FROM name";
		name n = new name();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				n.setNo(rs.getInt("id"));
				n.setName(rs.getString("Name"));
				System.out.println("id: " + n.getNo() + " Name: " + n.getName());
			}
			stmt.close();
			conn.close();
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exception");
		}
		catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
		}
	}
}
