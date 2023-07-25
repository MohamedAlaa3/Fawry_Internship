/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banking_application;

/**
 *
 * @author Mohamed Alaa
 */
public class SavingsAccount extends Account{
        private int interestRate;

    public SavingsAccount(int interestRate) {
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = (this.getBalance() * interestRate) / 100;
        System.out.println("The interest is: " + interest);
    }
    
}
