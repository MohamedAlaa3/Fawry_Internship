package org.example.SenssorsFactory;

import java.util.Random;

public class SmokeSensor implements Sensor {
    public boolean isDetected() {
        return smokeDetected;
    }

    boolean smokeDetected = false;

    @Override
    public void detect() {
        Random random = new Random();
        if (random.nextInt(100) < 10) {
            smokeDetected = true;
            System.out.println("Smoke detected");
        } else {
            smokeDetected = false;
            System.out.println("No smoke detected");
        }

    }
}
