package com.ibik.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {	
	    private static final String DB_URL = "jdbc:mysql://localhost:3306/form_quiz";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	    }
	}