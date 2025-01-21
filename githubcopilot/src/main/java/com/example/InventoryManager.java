package com.example;

import java.util.*;

public class InventoryManager {
    private Map<Integer, Product> products = new HashMap<>();

    /**
     * Adds a new product to the inventory.
     * @param id the product ID
     * @param name the product name
     * @param price the product price
     * @throws IllegalArgumentException if the name is null or empty
     */
    public void addProduct(int id, String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        products.put(id, new Product(name, price));
    }

    /**
     * Updates the quantity of a product.
     * @param id the product ID
     * @param quantity the new quantity
     * @throws IllegalArgumentException if the product is not found
     */
    public void updateProductQuantity(int id, int quantity) {
        Product product = products.get(id);
        if (product != null) {
            product.setQuantity(quantity);
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }

    /**
     * Removes a product from the inventory.
     * @param id the product ID
     */
    public void removeProduct(int id) {
        products.remove(id);
    }

    /**
     * Lists all products in the inventory.
     * @return an unmodifiable list of products
     */
    public List<Product> listProducts() {
        List<Product> productList = new ArrayList<>(products.values());
        productList.forEach(product -> {
            System.out.println(String.format("Product Name: %s, Price: %.2f, Quantity: %d", product.getName(), product.getPrice(), product.getQuantity()));
        });
        return Collections.unmodifiableList(productList);
    }

    public static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
            this.quantity = 0;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("Product{name='%s', price=%.2f, quantity=%d}", name, price, quantity);
        }
    }

    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        
        System.out.println("Adding products:");
        inventoryManager.addProduct(1, "Laptop", 10);
        inventoryManager.addProduct(2, "Mobile", 20);
        inventoryManager.addProduct(3, "Tablet", 30);
        inventoryManager.listProducts();
        
        System.out.println("\nUpdating product quantity:");
        inventoryManager.updateProductQuantity(1, 5);
        inventoryManager.listProducts();
        
        System.out.println("\nRemoving a product:");
        inventoryManager.removeProduct(2);
        inventoryManager.listProducts();
    }
}