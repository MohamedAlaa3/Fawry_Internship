package org.example.SenssorsFactory;

public class SonyCompany extends SensorCompany {

    @Override
    public Sensor getSensor(String sensorType) {
        if (sensorType.equalsIgnoreCase("MotionSensor")) {
            return new MotionSensor();
        } else if (sensorType.equalsIgnoreCase("SmokeSensor")) {
            return new SmokeSensor();
        }
        return null;
    }
}
