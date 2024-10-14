package com.mycompany.furnituremanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


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

  
    public int getId() { return id; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getName() { return name; }
}


class InventoryManager {
    private List<FurnitureItem> inventory = new ArrayList<>();
    private final FileManager fileManager = new FileManager();

    public void addFurniture(FurnitureItem item) {
        inventory.add(item);
        fileManager.saveInventory(inventory); 
    }

   
    public void removeFurniture(int id) {
        boolean found = false;  
        for (FurnitureItem item : inventory) {
            if (item.getId() == id) {
                inventory.remove(item);
                fileManager.saveInventory(inventory);
                System.out.println("Furniture with ID " + id + " removed successfully.");
                found = true;
                break;  
            }
        }
        if (!found) {
            System.out.println("Furniture with ID " + id + " not found in the inventory.");
        }
    }


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

    
    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("The inventory is currently empty.");
        } else {
            for (FurnitureItem item : inventory) {
                item.displayItem();
            }
        }
    }

   
    public void loadInventory() {
        this.inventory = fileManager.loadInventory();
        if (inventory.isEmpty()) {
            System.out.println("No inventory data found.");
        }
    }


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

    
    public void clearInventory() {
        inventory.clear();  
        fileManager.clearInventory(); 
        System.out.println("Inventory cleared successfully.");
    }
}


class FileManager {
    private final String FILE_PATH = "D:\\UNIVERSITY\\SEMESTER 5\\ADVANCE COMPUTER PROGRAMMING\\project\\inventory.txt";


    public void saveInventory(List<FurnitureItem> inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    
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
    
    public void clearInventory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<FurnitureItem>());  // Write an empty list to the file
            System.out.println("Inventory cleared.");
        } catch (IOException e) {
            System.out.println("Error clearing inventory: " + e.getMessage());
        }
    }
}

public class FurnitureManagementSystem {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.loadInventory();  
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
                        scanner.nextLine();  
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
                        scanner.nextLine();  
                        System.out.print("Enter Furniture Name to Search: ");
                        String searchName = scanner.nextLine();
                        inventoryManager.searchFurnitureByName(searchName);
                    }
                    
                    case 7 -> {
                        
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
                scanner.nextLine(); 
            }
        }
        return value;
    }

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
                scanner.nextLine(); 
            }
        }
        return value;
    }
}
