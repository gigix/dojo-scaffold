package org.codingdojo.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MissionTest {
    @Test
    public void should_create_mission_with_text() {
        String missionText = "10 20\n" + "3 5 w\n" + "FFLFLLFFFFFRFFRRFFRRF";
        Mission mission = new Mission(missionText);
        assertThat(mission.report(), is("2 9 e"));
    }
}
