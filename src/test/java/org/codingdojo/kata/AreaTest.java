package org.codingdojo.kata;

import org.junit.Test;

import static org.codingdojo.kata.Direction.NORTH;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AreaTest {
    @Test
    public void should_create_area_with_max_x_and_y() {
        Area area = new Area(3, 5);
        assertThat(area.numberOfRows(), is(5));

        Grid firstGrid = area.gridAt(0, 0);
        assertThat(firstGrid.toString(), is("0 0"));
        assertThat(firstGrid.right().toString(), is("1 0"));
        assertThat(firstGrid.above().toString(), is("0 1"));
    }

    @Test
    public void should_deploy_rover_with_initial_status() {
        Area area = new Area(3, 5);
        Rover rover = area.deploy(2, 1, NORTH);
        assertThat(rover.report(), is("2 1 N"));
    }
}
