package view;

import controller.AuthController;
import model.User;

import java.util.Scanner;

public class LoginView {
    private AuthController authController;
    private Scanner scanner;
    private User currentUser = null; // Menyimpan pengguna yang sedang login

    public LoginView() {
        authController = new AuthController();
        scanner = new Scanner(System.in);
    }

    public void showLoginMenu() {
        System.out.println("\n=== Login Menu ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authController.loginUser(email, password);
        if (user != null) {
            System.out.println("Welcome, " + user.getName());
            this.currentUser = user; // Menyimpan pengguna yang berhasil login
        } else {
            System.out.println("Invalid email or password!");
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

    // Getter untuk pengguna yang sedang login
    public User getCurrentUser() {
        return currentUser;
    }
}
