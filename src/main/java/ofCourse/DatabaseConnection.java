package ofCourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	final private String url = "jdbc:postgresql://softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com/postgres";
	final private String user = "administrator";
	final private String password = "password";
	private Connection conn;
	private static DatabaseConnection databaseConnection = new DatabaseConnection();
	
	
	private DatabaseConnection(){
		conn = null;
	    try {
	        conn = DriverManager.getConnection(url, user, password);
	        System.out.println("Connected to the PostgreSQL server successfully.");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public static DatabaseConnection getInstance() {
		return databaseConnection;
	}
	
}
