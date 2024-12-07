package view;

import controller.ProductController;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private ProductController productController;
    private Scanner scanner;

    public ProductView() {
        productController = new ProductController();
        scanner = new Scanner(System.in);
    }

    public void displayAllProducts() {
        System.out.println("=== Product List ===");
        List<Product> products = productController.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : products) {
                System.out.println("ID: " + product.getId() +
                        " | Name: " + product.getName() +
                        " | Price: " + product.getPrice() +
                        " | Stock: " + product.getStock() + 
                        " | Category: " + product.getCategoryName());
            }
        }
    }

    public void addProduct() {
        CategoryView categoryView = new CategoryView();
        categoryView.displayCategories();

        System.out.println("Enter the category ID for the product: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine(); // Consume newline.

        System.out.println("=== Add Product ===");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consume newline.

        Product product = new Product(name, description, price, stock);
        product.setCategoryId(categoryId);

        if (productController.addProduct(product)) {
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Failed to add product.");
        }
    }

    public void displayProductsByCategory() {
        CategoryView categoryView = new CategoryView();
        categoryView.displayCategories();

        System.out.print("Enter category ID to filter products: ");
        int categoryId = scanner.nextInt();
        scanner.nextLine(); // Consume newline.

        List<Product> products = productController.getProductsByCategory(categoryId);
        if (products.isEmpty()) {
            System.out.println("No products found in this category.");
        } else {
            System.out.println("=== Products in Selected Category ===");
            for (Product product : products) {
                System.out.println("ID: " + product.getId() +
                        " | Name: " + product.getName() +
                        " | Price: " + product.getPrice() +
                        " | Stock: " + product.getStock());
            }
        }
        System.out.println("");
    }

}
