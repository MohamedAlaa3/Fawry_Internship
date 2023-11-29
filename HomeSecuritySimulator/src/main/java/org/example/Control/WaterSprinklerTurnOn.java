package org.example.Control;

public class WaterSprinklerTurnOn implements Command {
    private WaterSprinkler waterSprinkler;

    public WaterSprinklerTurnOn(WaterSprinkler waterSprinkler) {
        this.waterSprinkler = waterSprinkler;
    }

    @Override
    public void execute() {
        waterSprinkler.open();
    }
}
