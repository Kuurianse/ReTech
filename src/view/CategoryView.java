package view;

import controller.CategoryController;
import model.Category;

import java.util.List;
import java.util.Scanner;

public class CategoryView {
    private CategoryController categoryController;
    private Scanner scanner;

    public CategoryView() {
        categoryController = new CategoryController();
        scanner = new Scanner(System.in);
    }

    public void addCategory() {
        System.out.println("=== Add Category ===");
        System.out.print("Category Name: ");
        String name = scanner.nextLine();

        Category category = new Category(name);
        if (categoryController.addCategory(category)) {
            System.out.println("Category added successfully!");
        } else {
            System.out.println("Failed to add category.");
        }
    }

    public void displayCategories() {
        System.out.println("=== Categories ===");
        List<Category> categories = categoryController.getAllCategories();
        if (categories.isEmpty()) {
            System.out.println("No categories available.");
        } else {
            for (Category category : categories) {
                System.out.println("ID: " + category.getId() + " | Name: " + category.getName());
            }
        }
    }
}