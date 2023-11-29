package org.example.Alert;

public interface Alert {

    public void subscribe(Subscriber subscriber);

    public void unsubscribe(Subscriber subscriber);

    public void notifyObservers(String message);
}
