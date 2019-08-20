package org.codingdojo.kata;

import com.google.common.base.Function;

public class Direction {
    public static final Direction NORTH = new Direction("N", Grid::above);
    public static final Direction SOUTH = new Direction("S", Grid::below);

    private String text;
    private Function<Grid, Grid> wayToNext;

    public Direction(String text, Function<Grid, Grid> wayToNext) {
        this.text = text;
        this.wayToNext = wayToNext;
    }

    @Override
    public String toString() {
        return text;
    }

    Grid nextGrid(Grid grid) {
        return wayToNext.apply(grid);
    }
}
