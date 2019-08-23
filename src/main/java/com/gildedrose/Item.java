package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.Sulfuras;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    public static Item createNormalItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    public static Item createAgedBrie(int sellIn, int quality) {
        return new AgedBrie(sellIn, quality);
    }

    public static Item createBackstagePass(int sellIn, int quality) {
        return new BackstagePass(sellIn, quality);
    }

    public static Item createSulfuras(int sellIn, int quality) {
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

    void passOneDay() {
        updateSellInDays();
        updateQuality();
        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    protected void updateSellInDays() {
        sellIn = sellIn - 1;
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateQualityAfterExpiration() {
        decreaseQuality();
    }

    protected void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }
}
