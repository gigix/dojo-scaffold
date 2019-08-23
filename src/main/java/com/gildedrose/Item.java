package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.Sulfuras;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    static public Item createNormalItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    static public Item createBackstagePass(int sellIn, int quality) {
        return new BackstagePass(sellIn, quality);
    }

    static public Item createAgedBrie(int sellIn, int quality) {
        return new AgedBrie(sellIn, quality);
    }

    static public Item createSulfuras(int sellIn, int quality) {
        return new Sulfuras(sellIn, quality);
    }

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    boolean isBetterQualityWhenTimeGoesBy() {
        return isAgedBrie() || isBackstagePass();
    }

    void passOneDay() {
        updateSellInDays();
        updateQuality();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    private void updateQuality() {
        if (!isBetterQualityWhenTimeGoesBy()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality = quality - 1;
                }
            }
        } else {
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
    }

    private void updateQualityAfterExpiration() {
        if (!isAgedBrie()) {
            if (!isBackstagePass()) {
                if (quality > 0) {
                    if (!isSulfuras()) {
                        quality = quality - 1;
                    }
                }
            } else {
                quality = 0;
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    private void updateSellInDays() {
        if (!isSulfuras()) {
            sellIn = sellIn - 1;
        }
    }
}
