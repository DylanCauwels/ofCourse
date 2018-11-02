import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String url = "jdbc:postgresql://softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com/postgres";
		final String user = "administrator";
		final String password = "password";
		
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        
	}

}
