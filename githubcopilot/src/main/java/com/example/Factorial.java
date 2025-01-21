package com.example;

public class Factorial {

    public static void main(String[] args) {
        // Test the factorial function with a positive number
        System.out.println("Factorial of 5: " + factorial(5));
        
        // Test the factorial function with 0
        System.out.println("Factorial of 0: " + factorial(0));
        
        // Test the factorial function with a negative number (will throw an exception)
        try {
            System.out.println("Factorial of -8: " + factorial(-8));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Calculates the factorial of a non-negative integer.
     * @param n the number to calculate the factorial of
     * @return the factorial of the number
     * @throws IllegalArgumentException if the number is negative
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}