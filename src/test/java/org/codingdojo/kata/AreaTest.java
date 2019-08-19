package org.codingdojo.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class AreaTest {
    @Test
    public void should_initialize_area_with_text() {
        Area area = new Area("10 20");
        assertThat(area.x, is(10));
        assertThat(area.y, is(20));
    }

    @Test
    public void should_deploy_rover_to_specific_point() {
        Area area = new Area("10 20");
        Rover rover = area.deploy("3 5 w");
        assertNotNull(rover);
    }
}
