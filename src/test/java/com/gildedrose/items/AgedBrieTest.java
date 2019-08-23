package com.gildedrose.items;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AgedBrieTest {
    @Test
    public void quality_should_never_exceed_50() {
        AgedBrie agedBrie = new AgedBrie(0, 48);
        agedBrie.passOneDay();
        assertThat(agedBrie.quality, is(50));
        agedBrie.passOneDay();
        assertThat(agedBrie.quality, is(50));
    }
}