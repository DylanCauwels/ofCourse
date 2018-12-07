package ofCourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
	final private String url = "jdbc:postgresql://softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com/postgres";
	final private String user = "administrator";
	final private String password = "password";
	private static Connection conn;
	private static DatabaseConnection databaseConnection = new DatabaseConnection();
	
	
	private DatabaseConnection(){
	    try {
	        conn = DriverManager.getConnection(url, user, password);
	        System.out.println("Connected to the PostgreSQL server successfully.");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public static DatabaseConnection getInstance() {
		return databaseConnection;
	}
	
	public ResultSet getResultSet(String column) {  
		try{
			
			String query = "SELECT " + column + " FROM softwarelab.registrar";
			Statement statement =  conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			return resultSet;
			
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		
	}
	
	public ResultSet getRowResultSet(String column, String columnValue) {
		try{
			if(column.contains("-")){
				column = "\"" + column + "\"";
			}
			String query = "SELECT * FROM softwarelab.registrar WHERE " + column + "=" + columnValue;
			Statement statement =  conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			return resultSet;
			
		}catch(Exception e){
			System.out.println(e);
			return null;
		
		}
	}
	
	
	public static Connection getConnection() {
		return conn;
	}
}
