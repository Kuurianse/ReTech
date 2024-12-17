package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;

public class ProductRepository {

    public static int getProductStock(int productId) {
        String query = "SELECT stock FROM products WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("stock");
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch product stock: " + e.getMessage());
        }
        return -1; 
    }
    
    public static boolean updateProductStock(int productId, int newStock) {
        String query = "UPDATE products SET stock = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, newStock);
            statement.setInt(2, productId);
            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Failed to update product stock: " + e.getMessage());
            return false;
        }
    }
}

