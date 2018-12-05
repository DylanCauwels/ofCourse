package ofCourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	final private String url = "jdbc:postgresql://softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com/postgres";
	final private String user = "administrator";
	final private String password = "password";
	private static Connection conn;
	private static DatabaseConnection databaseConnection;
	
	
	private DatabaseConnection(){
	    try {
	        conn = DriverManager.getConnection(url, user, password);
	        System.out.println("Connected to the PostgreSQL server successfully.");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public static DatabaseConnection getInstance() {
		if(databaseConnection == null) {
			databaseConnection = new DatabaseConnection();
		}
		return databaseConnection;
	}
	
	public static Connection getConnection() {
		return conn;
	}
}
