package view;

import controller.AuthController;
import model.User;

import java.util.Scanner;

public class LoginView {
    private AuthController authController;
    private Scanner scanner;

    public LoginView() {
        authController = new AuthController();
        scanner = new Scanner(System.in);
    }

    public User showLoginMenu() {
        System.out.println("\n=== Login Menu ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authController.loginUser(email, password);
        if (user != null) {
            System.out.println("Welcome, " + user.getName());
            return user;
        } else {
            System.out.println("Invalid email or password!");
            return null;
        }
    }

    public void showRegisterMenu() {
        System.out.println("\n=== Register Menu ===");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = new User(name, email, password, "customer");
        if (authController.registerUser(user)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed!");
        }
    }
}
