package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	public static void main(String[] args) {
		String jdbcURLString = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "#Hb1student";
		try {
			System.out.println("Connecting to database: " + jdbcURLString);
			Connection conn = DriverManager.getConnection(jdbcURLString,user,password);
			System.out.println("Connection Successful");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
