package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

        if (sellIn < 10) {
            increaseQuality();
        }

        if (sellIn < 5) {
            increaseQuality();
        }
    }
}
