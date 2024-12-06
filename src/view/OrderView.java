package view;

import controller.OrderController;
import model.Order;

import java.util.List;

public class OrderView {
    private OrderController orderController;

    public OrderView() {
        orderController = new OrderController();
    }

    public void displayOrderHistory(int userId) {
        System.out.println("=== Order History ===");
        List<Order> orders = orderController.getOrderHistory(userId);
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Order order : orders) {
                System.out.println("Order ID: " + order.getId() +
                        " | Total Price: " + order.getTotalPrice() +
                        " | Status: " + order.getStatus());
            }
        }
    }
}
