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
public class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotalCost() {
        double Total=0;
        
        for (Product product : products) {
            Total+=product.getPrice();
            
        }
        return Total;
    }

    public List<Product> getProducts() {
        return products;
    }
    
}
