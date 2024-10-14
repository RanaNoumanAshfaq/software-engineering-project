package com.mycompany.furnituremanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// FurnitureItem Class
class FurnitureItem implements Serializable {
    private final int id;
    private final String name;
    private final double price;
    private int quantity;

    public FurnitureItem(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void displayItem() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity);
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getName() { return name; }
}

// InventoryManager Class
class InventoryManager {
    private List<FurnitureItem> inventory = new ArrayList<>();
    private final FileManager fileManager = new FileManager();

    // Add furniture item
    public void addFurniture(FurnitureItem item) {
        inventory.add(item);
        fileManager.saveInventory(inventory);  // Save inventory to file
    }

    // Remove furniture item
    public void removeFurniture(int id) {
        boolean found = false;  // Flag to check if the item exists
        for (FurnitureItem item : inventory) {
            if (item.getId() == id) {
                inventory.remove(item);
                fileManager.saveInventory(inventory);
                System.out.println("Furniture with ID " + id + " removed successfully.");
                found = true;
                break;  // Exit loop after removing
            }
        }
        if (!found) {
            System.out.println("Furniture with ID " + id + " not found in the inventory.");
        }
    }

    // Update furniture quantity
    public void updateFurniture(int id, int newQuantity) {
        boolean found = false;
        for (FurnitureItem item : inventory) {
            if (item.getId() == id) {
                item.setQuantity(newQuantity);
                fileManager.saveInventory(inventory);
                System.out.println("Furniture with ID " + id + " updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Furniture with ID " + id + " not found in the inventory.");
        }
    }

    // View all inventory items
    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("The inventory is currently empty.");
        } else {
            for (FurnitureItem item : inventory) {
                item.displayItem();
            }
        }
    }

    // Load inventory from file
    public void loadInventory() {
        this.inventory = fileManager.loadInventory();
        if (inventory.isEmpty()) {
            System.out.println("No inventory data found.");
        }
    }

    // View furniture details by ID
    public void viewFurnitureById(int id) {
        boolean found = false;
        for (FurnitureItem item : inventory) {
            if (item.getId() == id) {
                item.displayItem();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Furniture with ID " + id + " not found.");
        }
    }

    // Search by name
    public void searchFurnitureByName(String name) {
        boolean found = false;
        for (FurnitureItem item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.displayItem();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No furniture found with the name: " + name);
        }
    }

    // Clear all inventory items
    public void clearInventory() {
        inventory.clear();  // Clear the list in memory
        fileManager.clearInventory();  // Clear the file
        System.out.println("Inventory cleared successfully.");
    }
}


// FileManager Class (Handles file I/O)
class FileManager {
    private final String FILE_PATH = "D:\\UNIVERSITY\\SEMESTER 5\\ADVANCE COMPUTER PROGRAMMING\\project\\inventory.txt";

    // Save inventory to file
    public void saveInventory(List<FurnitureItem> inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // Load inventory from file
    public List<FurnitureItem> loadInventory() {
        List<FurnitureItem> inventory = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            inventory = (List<FurnitureItem>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
        return inventory;
    }

    // Clear inventory file
    public void clearInventory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<FurnitureItem>());  // Write an empty list to the file
            System.out.println("Inventory cleared.");
        } catch (IOException e) {
            System.out.println("Error clearing inventory: " + e.getMessage());
        }
    }
}

// Main Class for Testing
public class FurnitureManagementSystem {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.loadInventory();  // Load inventory from file
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            
            while (running) {
                System.out.println("\n--- Furniture Management System ---");
                System.out.println("1. Add Furniture");
                System.out.println("2. Remove Furniture");
                System.out.println("3. Update Furniture");
                System.out.println("4. View Inventory");
                System.out.println("5. View Furniture by ID");
                System.out.println("6. Search Furniture by Name");
                System.out.println("7. Clear All Inventory");
                System.out.println("8. Exit");
                
                int choice = getIntInput(scanner, "Enter your choice: ");
                
                switch (choice) {
                    case 1 -> {
                        int id = getIntInput(scanner, "Enter Furniture ID: ");
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter Furniture Name: ");
                        String name = scanner.nextLine();
                        double price = getDoubleInput(scanner, "Enter Furniture Price: ");
                        int quantity = getIntInput(scanner, "Enter Furniture Quantity: ");
                        
                        FurnitureItem item = new FurnitureItem(id, name, price, quantity);
                        inventoryManager.addFurniture(item);
                    }
                    
                    case 2 -> {
                        int removeId = getIntInput(scanner, "Enter Furniture ID to Remove: ");
                        inventoryManager.removeFurniture(removeId);
                    }
                    
                    case 3 -> {
                        int updateId = getIntInput(scanner, "Enter Furniture ID to Update: ");
                        int newQuantity = getIntInput(scanner, "Enter New Quantity: ");
                        inventoryManager.updateFurniture(updateId, newQuantity);
                    }
                    
                    case 4 -> inventoryManager.viewInventory();
                    
                    case 5 -> {
                        int viewId = getIntInput(scanner, "Enter Furniture ID to View: ");
                        inventoryManager.viewFurnitureById(viewId);
                    }
                    
                    case 6 -> {
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter Furniture Name to Search: ");
                        String searchName = scanner.nextLine();
                        inventoryManager.searchFurnitureByName(searchName);
                    }
                    
                    case 7 -> {
                        // Clear All Inventory
                        System.out.println("Are you sure you want to clear all inventory? (yes/no): ");
                        String confirmation = scanner.next();
                        if (confirmation.equalsIgnoreCase("yes")) {
                            inventoryManager.clearInventory();
                        } else {
                            System.out.println("Clear inventory action cancelled.");
                        }
                    }
                    
                    case 8 -> {
                        running = false;
                        System.out.println("Exiting system.");
                    }
                    
                    default -> System.out.println("Invalid choice. Please select from the menu.");
                }
            }
        }
    }

    // Method to safely get integer input with error handling
    private static int getIntInput(Scanner scanner, String prompt) {
        int value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print(prompt);
                value = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();  // Clear the invalid input
            }
        }
        return value;
    }

    // Method to safely get double input with error handling
    private static double getDoubleInput(Scanner scanner, String prompt) {
        double value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print(prompt);
                value = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();  // Clear the invalid input
            }
        }
        return value;
    }
}
