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
	
	public void testGetCalendarTime() {
	        Algorithm.Section newSection = new Algorithm.Section(1234, "MT", "2100", "2200",  "EE", "312", "M", "EberFuckFace", 6.9, 2.3);
	        Algorithm.Section newSection2 = new Algorithm.Section(1235, "MW", "1300", "1700", "EE", "312", "M", "Eberstupid", 7.3, 4.2);
	        Algorithm.Section newSection3 = new Algorithm.Section(1236, "MTWTF", "2100", "2200", "EE", "312", "M", "EberFuckFace", 3.4, 2.3);
	        newSection.getCalendarTime();
	        newSection2.getCalendarTime();
	        newSection3.getCalendarTime();

	    }

}
