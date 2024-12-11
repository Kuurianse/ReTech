package controller;

import database.DatabaseConnection;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Factory.OrderFactory;

public class OrderController {
    private Connection connection;

    public OrderController() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Order> getOrderHistory(int userId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(new OrderFactory(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getDouble("total_price"),
                        resultSet.getString("status")
                ).get());
            }
        } catch (SQLException e) {
            System.out.println("Error fetching order history: " + e.getMessage());
        }
        return orders;
    }
}
