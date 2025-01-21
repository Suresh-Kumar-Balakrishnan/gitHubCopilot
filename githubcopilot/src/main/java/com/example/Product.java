package com.example;

//Product class represents the id,name and quantity of a product
public class Product {
    private int id;
    private String name;
    private int quantity;

    //Constructor to initialize the product
    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    //Getter method to get the id of the product
    public int getId() {
        return id;
    }

    //Setter method to set the id of the product
    public void setId(int id) {
        this.id = id;
    }

    //Getter method to get the name of the product
    public String getName() {
        return name;
    }

    //Setter method to set the name of the product
    public void setName(String name) {
        this.name = name;
    }

    //Getter method to get the quantity of the product
    public int getQuantity() {
        return quantity;
    }

    //Setter method to set the quantity of the product
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //toString method to return the string representation of the product
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    
}
