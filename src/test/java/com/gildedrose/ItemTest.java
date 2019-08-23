package com.gildedrose;

import com.gildedrose.items.BackstagePass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void should_increase_backstage_pass_quality_when_it_gets_close_to_expiration() {
        Item item = new BackstagePass(11, 20);
        item.passOneDay();
        assertThat(item.quality, is(21));
        item.passOneDay();
        assertThat(item.quality, is(23));

        item = new BackstagePass(6, 20);
        item.passOneDay();
        assertThat(item.quality, is(22));
        item.passOneDay();
        assertThat(item.quality, is(25));
    }
}