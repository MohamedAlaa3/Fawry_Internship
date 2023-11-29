package org.example.Control;

public class AlarmTurnOff implements Command {
    private Alarm alarm;

    public AlarmTurnOff(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.close();
    }
}
