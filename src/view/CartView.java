package view;

import controller.CartController;
import controller.ProductController;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class CartView {
    private CartController cartController;
    private ProductController productController;
    private Scanner scanner;

    public CartView() {
        cartController = new CartController();
        productController = new ProductController();
        scanner = new Scanner(System.in);
    }

    public void addToCart() {
        List<Product> products = productController.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products available to add to cart.");
            return;
        }

        System.out.println("=== Add to Cart ===");
        for (Product product : products) {
            System.out.println("ID: " + product.getId() +
                    " | Name: " + product.getName() +
                    " | Price: " + product.getPrice() +
                    " | Stock: " + product.getStock());
        }

        System.out.print("Enter product ID to add to cart: ");
        int productId = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline.

        Product selectedProduct = products.stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElse(null);

        if (selectedProduct == null || quantity > selectedProduct.getStock()) {
            System.out.println("Invalid product ID or quantity exceeds stock.");
        } else {
            cartController.addToCart(selectedProduct, quantity);
        }
    }

    public void viewCart() {
        cartController.viewCart();
    }

    public void checkout() {
        cartController.checkout();
    }
}
