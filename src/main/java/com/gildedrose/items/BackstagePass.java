package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected boolean isBackstagePass() {
        return true;
    }

    @Override
    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;

            if (isBackstagePass()) {
                if (sellIn < 10) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }

                if (sellIn < 5) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }
            }
        }
    }

    @Override
    protected void updateQualityAfterExpiration() {
        quality = 0;
    }
}
