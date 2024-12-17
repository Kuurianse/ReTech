package controller;

import model.CartItem;
import model.Notification;
import model.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import Factory.CartItemFactory;

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

        CartItem newItem = new CartItemFactory(product.getId(), product.getName(), quantity, product.getPrice()).get();
        cartItems.add(newItem);
        System.out.println("Added to cart: " + product.getName());
    }

    public void viewCart() {
        if (this.cartItems.isEmpty()) {
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

    public boolean checkCart() {
        if (this.cartItems.isEmpty()) {
            System.out.println("Your cart is empty. Add some products first!");
            return false ;
        }

        for (CartItem item : cartItems) {
            int currentStock = ProductRepository.getProductStock(item.getProductId());
            if (currentStock == -1) {
                System.out.println("Product not found: " + item.getProductName());
                return false;
            }
            if (currentStock < item.getQuantity()) {
                System.out.println("Insufficient stock for product: " + item.getProductName());
                return false;
            }
        }

        return true;
    }
    
    public double getCartTotal() {
    	  double total = 0;

          for (CartItem item : cartItems) {
 //             int currentStock = ProductRepository.getProductStock(item.getProductId());
//              boolean stockUpdated = ProductRepository.updateProductStock(item.getProductId(), currentStock - item.getQuantity());
              total += item.getPrice() * item.getQuantity();
//              System.out.println("Stock updated for product: " + item.getProductName());
          }

          return total;
       
    }
    
    public boolean clearCartItems() {
    	for (CartItem item : this.cartItems) {
    	int currentStock = ProductRepository.getProductStock(item.getProductId());
    	boolean stockUpdated = ProductRepository.updateProductStock(item.getProductId(), currentStock - item.getQuantity());
    	  if (!stockUpdated) {
              System.out.println("Product Purchasing Failed: " + item.getProductName());
              return false;
          }
    	}
    	// if updating product stock inside database successful
        this.cartItems.clear();
        return true;
    }


}
