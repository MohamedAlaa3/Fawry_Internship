package org.example.SenssorsFactory;

import java.util.Random;

public class MotionSensor implements Sensor{
    public boolean isDetected() {
        return motionDetected;
    }

    public boolean motionDetected = false;

        @Override
        public void detect() {
            Random random = new Random();
            if(random.nextInt(100) < 10){
                motionDetected = true;
                System.out.println("Motion detected");
            }
            else {
                motionDetected = false;
                System.out.println("No motion detected");
            }
        }
}
