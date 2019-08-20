package org.codingdojo.kata;

public class Rover {
    private Grid grid;
    private final Direction direction;

    Rover(Grid grid, Direction direction) {
        this.grid = grid;
        this.direction = direction;
    }

    public String report() {
        return grid.toString() + " " + direction.toString();
    }

    public void moveForward() {
        grid.sendToNext(this, direction);
    }

    void setGrid(Grid grid) {
        this.grid = grid;
    }
}
