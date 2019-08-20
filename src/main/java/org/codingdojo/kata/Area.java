package org.codingdojo.kata;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Area {
    private final List<Row> rows;

    public Area(int maxX, int maxY) {
        rows = newArrayList();
        for (int y = 0; y < maxY; y++) {
            Row row = new Row(maxX, y);
            rows.add(row);
        }
        for (int y = 0; y < maxY - 1; y++) {
            rowAt(y).upLinkTo(rowAt(y + 1));
        }
    }

    private Row rowAt(int y) {
        return rows.get(y);
    }

    public int numberOfRows() {
        return rows.size();
    }

    public Grid gridAt(int x, int y) {
        Row row = rows.get(y);
        return row.gridAt(x);
    }

    public Rover deploy(int x, int y, Direction direction) {
        Grid grid = gridAt(x, y);
        return new Rover(grid, direction);
    }
}
