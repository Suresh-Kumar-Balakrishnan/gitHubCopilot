package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class InventoryManagerTest {

    @Test
    public void testAddProduct() {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addProduct(1, "Laptop", 10.0);
        List<InventoryManager.Product> products = inventoryManager.listProducts();
        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getName());
        assertEquals(10.0, products.get(0).getPrice());
        assertEquals(0, products.get(0).getQuantity());
    }

    @Test
    public void testAddProductWithEmptyName() {
        InventoryManager inventoryManager = new InventoryManager();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inventoryManager.addProduct(1, "", 10.0);
        });
        assertEquals("Product name cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testUpdateProductQuantity() {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addProduct(1, "Laptop", 10.0);
        inventoryManager.updateProductQuantity(1, 5);
        List<InventoryManager.Product> products = inventoryManager.listProducts();
        assertEquals(5, products.get(0).getQuantity());
    }

    @Test
    public void testUpdateProductQuantityForNonExistentProduct() {
        InventoryManager inventoryManager = new InventoryManager();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inventoryManager.updateProductQuantity(1, 5);
        });
        assertEquals("Product not found", exception.getMessage());
    }

    @Test
    public void testRemoveProduct() {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addProduct(1, "Laptop", 10.0);
        inventoryManager.removeProduct(1);
        List<InventoryManager.Product> products = inventoryManager.listProducts();
        assertEquals(0, products.size());
    }

    @Test
    public void testListProducts() {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addProduct(1, "Laptop", 10.0);
        inventoryManager.addProduct(2, "Mobile", 20.0);
        List<InventoryManager.Product> products = inventoryManager.listProducts();
        assertEquals(2, products.size());
        assertEquals("Laptop", products.get(0).getName());
        assertEquals("Mobile", products.get(1).getName());
    }
}