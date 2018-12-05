package ofCourse;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class DatabaseConnectionTest {

	@Test
	public void testConnection() {
		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			Connection conn = dbConn.getConnection();
		}catch(Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void testResultSet() {
		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			Connection conn = dbConn.getConnection();
			Statement statement =  conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM softwarelab.registrar");
		}catch(Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void testNameWithDash() {
		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			Connection conn = dbConn.getConnection();
			Statement statement =  conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT \"lecture-days\" FROM softwarelab.registrar");
		}catch(Exception e) {
			fail(e.toString());
		}
	}

}
