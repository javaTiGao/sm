package org.sm.utils;

import java.sql.*;


public class DBUtil {
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/studentmanagement";
	private static String uName = "root";
	private static String passwd = "368472";
	
	
	public static Connection getConnection() {
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, uName, passwd);
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static void closeConn(ResultSet rs, PreparedStatement ps, Connection conn) {
		if (rs != null) {
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try{
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
		
		System.out.println(getConnection());
	}
}
