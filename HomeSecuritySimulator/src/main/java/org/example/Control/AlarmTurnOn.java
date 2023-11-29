package org.example.Control;

public class AlarmTurnOn implements Command {
    private Alarm alarm;

    public AlarmTurnOn(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.open();
    }
}
