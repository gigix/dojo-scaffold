package org.codingdojo.kata;

public class Mission {
    private final Area area;
    private final Rover rover;

    public Mission(String missionText) {
        String[] statements = missionText.split("\n");
        area = new Area(statements[0]);
        rover = area.deploy(statements[1]);
        rover.execute(statements[2]);
    }

    public String report() {
        return rover.status();
    }
}
