package org.example.Control;

public class WaterSprinklerTurnOff implements Command {
    private WaterSprinkler waterSprinkler;

    public WaterSprinklerTurnOff(WaterSprinkler waterSprinkler) {
        this.waterSprinkler = waterSprinkler;
    }

    @Override
    public void execute() {
        waterSprinkler.close();
    }
}
