import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = DatabaseConnection.getConnection();
		
		try{
			Statement statement =  conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT \"lecture-days\" FROM \"software-lab\".registrar");
			/*
			while(resultSet.next()) {
				System.out.println("ass");
				System.out.println(resultSet.getString(0));
				
			}
			*/
		}catch(Exception e){
			System.out.println(e);
		}
        
	}

}
