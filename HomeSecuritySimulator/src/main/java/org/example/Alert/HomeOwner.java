package org.example.Alert;

public class HomeOwner implements Subscriber {
    public String name;


    @Override
    public void MessageUpdate(String AlertName, String message) {
        System.out.println("Alert from: " + AlertName + " Message: " + message);
    }
}
