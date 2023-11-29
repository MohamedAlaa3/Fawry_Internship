package org.example;

public class SMSAdpter implements Message {
    private SMSold smsold;

    public SMSAdpter() {
        this.smsold = new SMSold();
    }

    @Override
    public String getMessage(String message) {
        return smsold.getMessage(message, message.length());
    }
}
