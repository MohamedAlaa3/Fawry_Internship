package org.example.store;

import org.example.account.AccountManager;
import org.example.account.AccountManagerImpl;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.List;

public class AccountManagerImplTest {

    @Test
    void testDeposite() {
        // Arrange
        AccountManagerImpl accountManagerImpl = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(100);
        int amount = 50;
        int expected = 150;

        // Act
        accountManagerImpl.deposit(customer, amount);

        // Assert
        Assertions.assertEquals(expected, customer.getBalance());
    }

    @Test
    void testWithdraw() {
        // Arrange
        AccountManagerImpl accountManagerImpl = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(100);
        int amount = 50;
        int expected = 50;

        // Act
        String expectedmessag = accountManagerImpl.withdraw(customer, amount);

        // Assert
        Assertions.assertEquals(expected, customer.getBalance());
        Assertions.assertEquals("success", expectedmessag);
    }

    @Test
    void testWithdrawWithInsufficientBalance() {
        // Arrange
        AccountManagerImpl accountManagerImpl = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(100);
        int amount = 150;
        String expected = "insufficient account balance";

        // Act
        String actual = accountManagerImpl.withdraw(customer, amount);

        // Assert
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(100, customer.getBalance());

    }
    @Test
    void testWithdrawWithCreditAloowed() {
        // Arrange
        AccountManagerImpl accountManagerImpl = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(100);
        customer.setVip(false);
        customer.setCreditAllowed(true);
        int amount = 500;
        String expected = "success";

        // Act
        String actual = accountManagerImpl.withdraw(customer, amount);

        // Assert
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(-400, customer.getBalance());
    }
    @Test
    void testWithdrawWithMaxCreditExceededAndVipAndCreditNotAllowed() {
        // Arrange
        AccountManagerImpl accountManagerImpl = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(100);
        customer.setVip(false);
        customer.setCreditAllowed(true);
        int amount = 2000;
        String expected = "mximum credit exceeded";

        // Act
        String actual = accountManagerImpl.withdraw(customer, amount);

        // Assert
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(100, customer.getBalance());
    }
    @Test
    void testWithdrawWithMaxCreditExceededAndVip() {
        // Arrange
        AccountManagerImpl accountManagerImpl = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(100);
        customer.setVip(true);
        customer.setCreditAllowed(true);
        int amount = 2000;
        int expected = -1900;

        // Act
        accountManagerImpl.withdraw(customer, amount);

        // Assert
        Assertions.assertEquals(expected, customer.getBalance());
    }



}
