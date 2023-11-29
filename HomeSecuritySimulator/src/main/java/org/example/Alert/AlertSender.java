package org.example.Alert;

import java.util.ArrayList;

public class AlertSender implements Alert {
    private String AlertName;
    private ArrayList<Subscriber> subscribers;

    public AlertSender(String AlerName) {
        this.AlertName = AlerName;
        subscribers = new ArrayList<Subscriber>();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);

    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);

    }

    @Override
    public void notifyObservers(String message) {
        subscribers.stream()
                .forEach(subscriber -> subscriber.MessageUpdate(this.AlertName, message));


    }
}
