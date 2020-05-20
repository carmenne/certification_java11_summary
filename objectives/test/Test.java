import java.io.*;
import java.sql.*;

public class Test {
	public static void main(String[] args) {
		
		try {
			exception();
		} catch (SQLException | IOException e) {
			System.out.println("END");
		}
			
	}
	
	private static void exception() throws SQLException, IOException {
	
		try {
			example();	
		} catch (Exception e) {
			System.out.println("I caught the exception " + e.getClass());
		}
	}
	
	private static void example() throws SQLException, IOException {
		throw new RuntimeException("RuntimeException");
	}
}
