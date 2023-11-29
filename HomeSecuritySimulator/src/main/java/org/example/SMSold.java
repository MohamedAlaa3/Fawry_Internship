package org.example;

public class SMSold {
    public String getMessage(String message, int messageLength) {
        if (messageLength > 10)
            return "<sms><message>" + message.substring(0, 9) + "</message></sms>";
        else if (messageLength < 10)
            return "<sms><message>" + message + "</message></sms>";
        else if (messageLength == 10)
            return "<sms><message>" + message + "</message></sms>";

        return "";

    }
}
