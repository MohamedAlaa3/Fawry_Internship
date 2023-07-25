/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.online_shop;

/**
 *
 * @author Mohamed Alaa
 */
import java.util.ArrayList;
import java.util.List;
public class OrderProcessor {
        public void placeOrder(ShoppingCart cart) {
        List<Product> products = cart.getProducts();
        if (products.isEmpty()) {
            System.out.println("Shopping cart is empty. No order has been placed.");
            return;
        }
        System.out.println("Order Details:");
        products.forEach(product -> System.out.println("- " + product.getName() + ": " + product.getPrice()));
        System.out.println("Total cost: " + cart.calculateTotalCost());
    }
    
}
