package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.List;

public class StoreBetterTest {


    @Test
    void
    test2() {
        AccountManager accountManager = mock(AccountManager.class);

        Customer customer = new Customer();
        Product product = new Product();

        when(accountManager.withdraw(eq(customer), anyInt()))
                .thenReturn("success");

//        when(accountManager.withdraw(eq(customer), anyInt()))
//                .then(new Answer<String>() {
//                    @Override
//                    public String answer(InvocationOnMock invocationOnMock) throws Throwable {
//                        int amount = invocationOnMock.getArgumentAt(1, Integer.class);
//                        return "SUCCESS" + amount;
//                    }
//                });

        System.out.println(accountManager.withdraw(customer, 10));
        System.out.println(accountManager.withdraw(customer, 11));

        verify(accountManager).withdraw(customer, 10);
        verify(accountManager).withdraw(customer, 11);
//        verify(accountManager).withdraw(customer, 12);

        verifyZeroInteractions(accountManager);

    }


//    @Test
//    void test() {
//        List list = mock(List.class);
//
//        list.add("red");
//        list.add("green");
//
//
//        verify(list).add("red");
//        verify(list).add("blue");
//
//
//    }
    @Test
    void tes3(){
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);

        Store store = new MyStore(accountManager);
        Product product = new Product();
        product.setQuantity(10);
        Customer customer = new Customer();

        when(accountManager.withdraw(eq(customer), anyInt()))
                .thenReturn("success");

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(9, product.getQuantity());

    }
    @Test
    void tes4(){
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);

        Store store = new MyStore(accountManager);
        Product product = new Product();
        product.setQuantity(0);
        Customer customer = new Customer();

        when(accountManager.withdraw(eq(customer), anyInt()))
                .thenReturn("success");

        // Act
        try {
            store.buy(product, customer);
        }
        catch (RuntimeException e){
            // Assert
            Assertions.assertEquals("Product out of stock", e.getMessage());
        }
    }
    @Test
    void tes5(){
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);

        Store store = new MyStore(accountManager);
        Product product = new Product();
        product.setQuantity(15);
        Customer customer = new Customer();

        when(accountManager.withdraw(eq(customer), anyInt()))
                .thenReturn("FAILED");

        // Act
        try {
            store.buy(product, customer);
        }
        catch (RuntimeException e){
            // Assert
            Assertions.assertEquals("Payment failure: FAILED", e.getMessage());
        }
    }
}
