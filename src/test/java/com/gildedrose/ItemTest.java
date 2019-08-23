package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.Item.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void backstage_pass_should_increase_quality_accelerated() {
        Item item = createBackstagePass(12, 5);
        item.passOneDay(); // sell in: 12 -> 11
        assertThat(item.quality, is(6));
        item.passOneDay(); // sell in: 11 -> 10
        assertThat(item.quality, is(7));
        item.passOneDay(); // sell in: 10 -> 9
        assertThat(item.quality, is(9));

        item.passOneDay(); // sell in: 9 -> 8
        item.passOneDay(); // sell in: 8 -> 7
        item.passOneDay(); // sell in: 7 -> 6
        item.passOneDay(); // sell in: 6 -> 5
        assertThat(item.quality, is(17));

        item.passOneDay(); // sell in: 5 -> 4
        assertThat(item.quality, is(20));
    }

    @Test
    public void should_decrease_extra_quality_after_expiration() {
        Item item = createNormalItem("normal item", 1, 10);
        item.passOneDay();
        assertThat(item.quality, is(9));
        item.passOneDay();
        assertThat(item.quality, is(7));
    }

    @Test
    public void should_not_decrease_extra_quality_after_expiration_for_sulfuras() {
        Item sulfuras = createSulfuras(0, 10);
        sulfuras.passOneDay();
        assertThat(sulfuras.quality, is(10));
    }

    @Test
    public void should_not_increase_quality_over_50() {
        Item item = createAgedBrie(0, 50);
        item.passOneDay();
        assertThat(item.quality, is(50));
    }

    @Test
    public void should_not_decrease_quality_under_0() {
        Item normalItem = createNormalItem("normal item", 10, 0);
        normalItem.passOneDay();
        assertThat(normalItem.quality, is(0));
    }
}