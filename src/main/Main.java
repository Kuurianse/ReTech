package main;

import view.CartView;
import view.LoginView;
import view.PaymentView;
import view.ProductView;
import model.User;

import java.util.Scanner;

import controller.CartController;

public class Main {
    private static User currentUser = null;  // Menyimpan pengguna yang sedang login
    
    Scanner scanner = new Scanner(System.in);
    CartController cartController = new CartController();
    CartView cartView = new CartView(this.cartController);
    LoginView loginView = new LoginView();
    ProductView productView = new ProductView();
    PaymentView paymentView = new PaymentView(this.cartController);
    
    public void customerMenu() {
    	while(true) {
    		System.out.println("\n=== E-Commerce Menu ===");
            System.out.println("1. Logout");
            System.out.println("2. View All Products");
            System.out.println("3. View Products by Category");
            System.out.println("4. Add to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
            case 1:
                currentUser = null; // Logout user
                System.out.println("You have logged out.");
                mainMenu();
                break;
            case 2:
                productView.displayAllProducts();
                break;
            case 3:
                productView.displayProductsByCategory();
                break;
            case 4:
                cartView.addToCart();
                break;
            case 5:
                cartView.viewCart();
                break;
            case 6:
                paymentView.displayCheckout();
                break;
            case 7:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
                continue;
            }
    	}
    }
    
    public void adminMenu() {
    	while(true) {
    		System.out.println("\n=== E-Commerce Menu ===");
            System.out.println("1. Logout");
            System.out.println("2. View All Products");
            System.out.println("3. View Products by Category");
            System.out.println("4. Add Product");        
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
            case 1:
                currentUser = null; // Logout user
                System.out.println("You have logged out.");
                mainMenu();
                break;
            case 2:
                productView.displayAllProducts();
                break;
            case 3:
                productView.displayProductsByCategory();
                break;
            case 4:
            	productView.addProduct();
                break;
            case 5:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
            }
    	}
    }
    
    public void mainMenu() {
    	while (true) {
            if (currentUser == null) {
            	System.out.println("\n=== E-Commerce Menu ===");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. View All Products");
                System.out.println("4. Exit");
                
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
    			case 1:
    				currentUser = loginView.showLoginMenu();
    				break;
    			case 2:
    				loginView.showRegisterMenu();
    				break;
    			case 3:
                    productView.displayAllProducts();
                    break;
				case 4:
	                System.out.println("Goodbye!");
	                System.exit(0);
	                break;
    			default:
    				System.out.println("Invalid choice!");
    				break;
    			}
            } else {
//                System.out.println("Welcome, " + currentUser.getName());
                if (currentUser.getRole().equals("customer")) {
                	customerMenu();
                } else {
                	adminMenu();
                }
            }
        }
    }
    
    public Main() {
        mainMenu();
    }

    public static void main(String[] args) {
        new Main();
    }
}
