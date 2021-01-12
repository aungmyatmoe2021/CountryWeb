package com.countryweb.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	public static Connection getDBConnection() {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class Found");
		}catch (ClassNotFoundException ex) {
			// TODO: handle exception
			System.out.println("Error : "+ex.getMessage());
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","root1234");
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeSqlResource(Connection conn, Statement stmt, ResultSet rset) {
		try {
			if(rset != null)
				rset.close();
			
			if(stmt != null)
				stmt.close();
			
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeSqlResource(Connection conn, PreparedStatement pstm, ResultSet rset) {
		try {
			if(rset != null)
				rset.close();
			
			if(pstm != null)
				pstm.close();
			
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
