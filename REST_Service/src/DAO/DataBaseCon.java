package DAO;

import java.sql.Connection;
import java.sql.DriverManager;



public class DataBaseCon {
	
	// db: testdb user: postgres pass: slaptazodis00 schema: test table: fisrst
	public static Connection DBConn() throws Exception{
		
		Connection conn = null;
		
		try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5432/testdb";
				conn = DriverManager.getConnection(url, "postgres" , "slaptazodis00");
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
