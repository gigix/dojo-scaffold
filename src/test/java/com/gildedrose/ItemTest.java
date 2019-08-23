package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void should_increase_backstage_pass_quality_when_it_gets_close_to_expiration() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        item.passOneDay();
        assertThat(item.quality, is(21));
        item.passOneDay();
        assertThat(item.quality, is(23));

        item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);
        item.passOneDay();
        assertThat(item.quality, is(22));
        item.passOneDay();
        assertThat(item.quality, is(25));
    }
}