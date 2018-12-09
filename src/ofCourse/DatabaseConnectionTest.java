package ofCourse;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class DatabaseConnectionTest {

	@Test
	public void testConnection() {
		Connection conn = null;
		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			conn = dbConn.getConnection();
		}catch(Exception e) {
			fail(e.toString());
		}
		assertNotNull(conn);
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
	
	@Test
	public void testGetResultSetAllColumns() {
		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			String column = "*";
			ResultSet resultSet = dbConn.getColumnResultSet(column);
			assertNotNull(resultSet);
		}catch(Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void testGetDistinctColumnResultSetAllColumns() {
		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			String column = "prefix";
			ResultSet resultSet = dbConn.getDistinctColumnResultSet(column);
			assertNotNull(resultSet);
			ArrayList<String> courseAbb = new ArrayList<String>(0);
			while(resultSet.next()) {
				if(courseAbb.contains(resultSet.getString("prefix"))) {
					fail("REPEAT");
				}else {
					courseAbb.add(resultSet.getString("prefix"));
				}
			} 
			
		}catch(Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void testGetResultSetColumn() {
		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			String column = "unique-number";
			ResultSet resultSet = dbConn.getColumnResultSet(column);
			assertNotNull(resultSet);
		}catch(Exception e) {
			fail(e.toString());
		}
	
	}
	@Test
	public void getRowResultSetTest() {
		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			String column = "unique-number";
			String value = "310";
			ResultSet resultSet = dbConn.getRowResultSet(column, value);
			resultSet.next();
			assertEquals(resultSet.getString("unique-number"), "310");
		}catch(Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void getDistinctRowResultSetTest() {
		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			String column = "unique-number";
			String value = "310";
			ResultSet resultSet = dbConn.getRowResultSet(column, value);
			
			ArrayList<String> courseAbb = new ArrayList<String>(0);
			while(resultSet.next()) {
				assertEquals(resultSet.getString("unique-number"), "310");
				if(courseAbb.contains(resultSet.getString("prefix"))) {
					fail("REPEAT");
				}else {
					courseAbb.add(resultSet.getString("prefix"));
				}
			} 
		}catch(Exception e) {
			fail(e.toString());
		}
	}
	

}
