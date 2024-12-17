package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection instance;
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    public static synchronized Connection getConnection() {
        try {
            if (instance == null || instance.isClosed()) {
                instance = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return instance;
    }
}