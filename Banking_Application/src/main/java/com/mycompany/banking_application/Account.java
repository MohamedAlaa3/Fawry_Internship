/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banking_application;

/**
 *
 * @author Mohamed Alaa
 */
public class Account {
    private String AccountNumber;
    private String AccountHolderName;
    private int Balance;
    

    public Account() {
        AccountNumber="";
        AccountHolderName="";
        Balance=0;
    }

    public void setAccountNumber(String NewAccountNumber)
    {
        AccountNumber=NewAccountNumber;
    }
    public String getAccountNumber()
    {
        return AccountNumber;
    }
        
    public void setBalance(int NewBalance)
    {
        Balance=NewBalance;
    }
    public int getBalance()
    {
        return Balance;
    }
        
    public void setAccountHolderName(String NewAccountHolderName)
    {
        AccountHolderName=NewAccountHolderName;
    }
    public String getAccountHolderName()
    {
        return AccountHolderName;
    }
    public void Deposite(int DepositeValue)
    {
        if(DepositeValue>0)
        {
            Balance+=DepositeValue;
            System.out.println("Deposite done successfully now your Balnce is" + Balance);

        }
    }
    
    public void Withdraw(int WithdrawValue)
    {
        if(WithdrawValue>0)
        {
            Balance-=WithdrawValue;
            System.out.println("Withdraw done successfully now your Balnce is" + Balance);
        }
    }

    
}
