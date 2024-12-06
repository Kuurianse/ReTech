package main;

import view.CartView;
import view.LoginView;
import view.ProductView;
import model.User;

import java.util.Scanner;

public class Main {
    private static User currentUser = null;  // Menyimpan pengguna yang sedang login

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        CartView cartView = new CartView();
        LoginView loginView = new LoginView();
        ProductView productView = new ProductView();

        while (true) {
            System.out.println("\n=== E-Commerce Menu ===");

            if (currentUser == null) {
                // Jika belum login, tampilkan menu login
                System.out.println("1. Login");
            } else {
                // Jika sudah login, tampilkan nama pengguna dan menu sesuai role
                System.out.println("Welcome, " + currentUser.getName());
                System.out.println("2. Logout");
            }
            
            System.out.println("3. Register");
            System.out.println("4. View All Products");
            System.out.println("5. View Products by Category");
            
            // Menu admin hanya ditampilkan jika pengguna adalah admin
            if (currentUser != null && "admin".equals(currentUser.getRole())) {
                System.out.println("6. Add Product (Admin only)");
            }
            
            System.out.println("7. Add to Cart");
            System.out.println("8. View Cart");
            System.out.println("9. Checkout");
            System.out.println("10. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline.

            switch (choice) {
                case 1:
                    loginView.showLoginMenu();
                    // Setelah login berhasil, simpan user
                    currentUser = loginView.getCurrentUser();
                    break;
                case 2:
                    currentUser = null; // Logout user
                    System.out.println("You have logged out.");
                    break;
                case 3:
                    loginView.showRegisterMenu();
                    break;
                case 4:
                    productView.displayAllProducts();
                    break;
                case 5:
                    productView.displayProductsByCategory();
                    break;
                case 6:
                    // Hanya admin yang bisa menambahkan produk
                    if (currentUser != null && "admin".equals(currentUser.getRole())) {
                        productView.addProduct();
                    } else {
                        System.out.println("You don't have permission to add products.");
                    }
                    break;
                case 7:
                    cartView.addToCart();
                    break;
                case 8:
                    cartView.viewCart();
                    break;
                case 9:
                    cartView.checkout();
                    break;
                case 10:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
