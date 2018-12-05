package ofCourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DatabaseConnection dbConn = DatabaseConnection.getInstance();
		Connection conn = dbConn.getConnection();
		
		try{
			Statement statement =  conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM softwarelab.registrar");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(2) + " " + resultSet.getString("lecture-end"));
				
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
        
	}

}
