package org.codingdojo.kata;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Row {
    private final List<Grid> grids;

    public Row(int maxX, int y) {
        grids = newArrayList();
        for (int x = 0; x < maxX; x++) {
            Grid grid = new Grid(x, y);
            grids.add(grid);
        }
        for (int x = 0; x < maxX - 1; x++) {
            gridAt(x).rightLinkTo(gridAt(x + 1));
        }
    }

    public int size() {
        return grids.size();
    }

    public Grid head() {
        return grids.get(0);
    }

    Grid gridAt(int x) {
        return grids.get(x);
    }

    public void upLinkTo(Row another) {
        for (int x = 0; x < grids.size(); x++) {
            gridAt(x).upLinkTo(another.gridAt(x));
        }
    }
}
