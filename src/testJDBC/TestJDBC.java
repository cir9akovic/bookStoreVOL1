package testJDBC;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/bookstore";
		String user = "root";
		String pass = "toor";
		
		try {
			
			System.out.println("Connecting to database " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
