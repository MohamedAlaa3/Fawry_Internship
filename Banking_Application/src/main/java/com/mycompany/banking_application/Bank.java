/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banking_application;

/**
 *
 * @author Mohamed Alaa
 */
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();
    
        public void addAccount(Account account) {
        accounts.add(account);
    }
    
    public void deposit(String accountNumber, int  amount) {
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                account.Deposite(amount);
                return;
            }
        }
        System.out.println("Account not found");
    }
        
    public void withdraw(String accountNumber, int amount) {
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                account.Withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found");
    }
    
        public void displayBalance(String accountNumber) {
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                System.out.println("The Balance is"+account.getBalance());
                return;
            }
        }
        System.out.println("Account not found");
    }
}
    

