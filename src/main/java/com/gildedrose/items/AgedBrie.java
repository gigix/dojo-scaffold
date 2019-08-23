package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQualityAfterExpiration() {
        increaseQuality();
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }
}
