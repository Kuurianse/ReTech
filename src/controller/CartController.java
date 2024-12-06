package controller;

import model.CartItem;
import model.Notification;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartController {
    private List<CartItem> cartItems;

    public CartController() {
        cartItems = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProductId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Updated quantity for product: " + product.getName());
                return;
            }
        }

        CartItem newItem = new CartItem(product.getId(), product.getName(), quantity, product.getPrice());
        cartItems.add(newItem);
        System.out.println("Added to cart: " + product.getName());
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("=== Your Cart ===");
        double total = 0;
        for (CartItem item : cartItems) {
            System.out.println("Product: " + item.getProductName() +
                    " | Quantity: " + item.getQuantity() +
                    " | Price: " + item.getPrice() +
                    " | Subtotal: " + (item.getPrice() * item.getQuantity()));
            total += item.getPrice() * item.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty. Add some products first!");
            return;
        }

        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }

        // Simpan pesanan ke database (opsional)
        System.out.println("=== Checkout ===");
        System.out.println("Total amount to pay: " + total);
        System.out.println("Thank you for your purchase!");

        Notification notification = new Notification("Your order has been placed successfully!");
        System.out.println("NOTIFICATION: " + notification.getMessage());
        
        // Notifikasi untuk admin
        Notification adminNotification = new Notification("New order received! Total: " + total);
        System.out.println("ADMIN NOTIFICATION: " + adminNotification.getMessage());

        cartItems.clear(); // Clear the cart after checkout.
    }

}
