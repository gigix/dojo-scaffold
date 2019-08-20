package org.codingdojo.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GridTest {
    @Test
    public void should_create_grid_with_coordinate() {
        Grid grid = new Grid(3, 5);
        assertThat(grid.toString(), is("3 5"));
    }

    @Test
    public void should_link_grids() {
        Grid one = new Grid(0, 0);
        Grid another = new Grid(1, 0);
        one.rightLinkTo(another);
        assertThat(one.right(), is(another));
        assertThat(another.left(), is(one));
    }
}
