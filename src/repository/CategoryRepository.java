package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;

public class CategoryRepository {
	
	public static String findCategory(int categoryId) {
		String query = "SELECT name FROM categories WHERE id = ?";
		try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch product categort: " + e.getMessage());
        }
        return null;
	}
	
}
