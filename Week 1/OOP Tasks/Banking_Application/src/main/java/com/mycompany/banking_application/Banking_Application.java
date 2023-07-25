/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banking_application;

/**
 *
 * @author Mohamed Alaa
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class Banking_Application {

public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("1. Open Account\n2. Deposit\n3. Withdraw\n4. Balance\n5. Exit");
            System.out.println("Choose an option: ");
            try {
                int option = scanner.nextInt();
                switch(option) {
                    case 1:
                        System.out.println("Enter account number: ");
                        String number = scanner.next();
                        System.out.println("Enter account holder name: ");
                        String name = scanner.next();
                        System.out.println("Enter initial deposit: ");
                        int balance = scanner.nextInt();
                        if(balance <= 0) {
                            System.out.println("Initial deposit must be positive.");
                            break;
                        }
                        System.out.println("Enter interest rate: ");
                        int rate = scanner.nextInt();
                        if(rate <= 0) {
                            System.out.println("Interest rate must be positive.");
                            break;
                        }
                        SavingsAccount newAccount =new SavingsAccount(rate);
                        newAccount.setAccountNumber(number);
                        newAccount.setAccountHolderName(name);
                        newAccount.setBalance(balance);
                        bank.addAccount(newAccount);
                        break;
                    case 2:
                        System.out.println("Enter account number: ");
                        number = scanner.next();
                        System.out.println("Enter amount to deposit: ");
                        int deposit = scanner.nextInt();
                        bank.deposit(number, deposit);
                        break;
                    case 3:
                        System.out.println("Enter account number: ");
                        number = scanner.next();
                        System.out.println("Enter amount to withdraw: ");
                        int withdraw = scanner.nextInt();
                        bank.withdraw(number, withdraw);
                        break;
                    case 4:
                        System.out.println("Enter account number: ");
                        number = scanner.next();
                        bank.displayBalance(number);
                        break;
                    case 5:
                        scanner.close();
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();  // Discard invalid input
            }
        }
    }
}
