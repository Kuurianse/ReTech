package view;

import controller.UserController;
import model.User;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private UserController userController;
    private Scanner scanner;

    public UserView() {
        userController = new UserController();
        scanner = new Scanner(System.in);
    }

    public void displayAllUsers() {
        List<User> users = userController.getAllUsers();
        System.out.println("=== User List ===");
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (User user : users) {
                System.out.println("ID: " + user.getId() +
                        " | Name: " + user.getName() +
                        " | Email: " + user.getEmail() +
                        " | Role: " + user.getRole());
            }
        }
    }

    public void deleteUser() {
        System.out.print("Enter the ID of the user to delete: ");
        int userId = scanner.nextInt();
        if (userController.deleteUser(userId)) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("Failed to delete user.");
        }
    }
}
