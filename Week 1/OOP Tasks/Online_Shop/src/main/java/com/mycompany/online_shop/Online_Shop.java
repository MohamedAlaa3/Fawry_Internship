/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.online_shop;

/**
 *
 * @author Mohamed Alaa
 */
public class Online_Shop {
    public static void main(String[] args) {
        // Create some sample products
        Product product1 = new Product("Laptop", 1000);
        Product product2 = new Product("Smartphone", 500);

        // Create a shopping cart and add products
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        // Display the total cost
        System.out.println("Total cost: " + cart.calculateTotalCost());

        // Create an instance of OrderProcessor and place the order
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.placeOrder(cart);
    }
}
