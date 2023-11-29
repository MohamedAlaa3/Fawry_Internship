package org.example;

import org.example.Alert.AlertSender;
import org.example.Alert.HomeOwner;
import org.example.Control.*;
import org.example.SenssorsFactory.Sensor;
import org.example.SenssorsFactory.SonyCompany;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.io.PrintWriter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Welcome to the Smart Home System");

        Log myLog = Log.getLogFile();
        SMSAdpter smsAdpter = new SMSAdpter();


        //applying apstract factory pattern
        SonyCompany sonyCompany = new SonyCompany();
        Sensor sensorMotion1 = sonyCompany.getSensor("MotionSensor");
        Sensor sensorSmoke1 = sonyCompany.getSensor("SmokeSensor");
        sensorMotion1.detect();
        sensorSmoke1.detect();

        //applying observer pattern
        AlertSender AlertMotion1 = new AlertSender("MotionSensor1");
        HomeOwner homeOwner1 = new HomeOwner();
        AlertMotion1.subscribe(homeOwner1);
        if (sensorMotion1.isDetected()) {
            AlertMotion1.notifyObservers(smsAdpter.getMessage("Motion detected"));
        }

        AlertSender AlertSmoke1 = new AlertSender("SmokeSensor1");
        AlertSmoke1.subscribe(homeOwner1);
        if (sensorSmoke1.isDetected()) {
            AlertSmoke1.notifyObservers(smsAdpter.getMessage("Smoke detected"));
        }

        //applying command pattern and adapter pattern and singleton pattern
        RemoteControl remoteControl = new RemoteControl();
        WaterSprinkler waterSprinkler = new WaterSprinkler();
        Alarm alarm = new Alarm();
        //myLog.write((LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString()) + " smoke detected");

        if (sensorSmoke1.isDetected()) {
            remoteControl.setCommand(new WaterSprinklerTurnOn(waterSprinkler));
            remoteControl.press();
            //myLog.write(((LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString()) + "smoke detected"));

        }
        if (sensorMotion1.isDetected()) {
            remoteControl.setCommand(new AlarmTurnOn(alarm));
            remoteControl.press();
            //myLog.write(((LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString()) + "motion detected"));
        }
        //This SMS message can be sent i different format, so adaptability is required.


    }
}