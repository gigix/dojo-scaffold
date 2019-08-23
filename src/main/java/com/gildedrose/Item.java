package com.gildedrose;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected boolean isSulfuras() {
        return false;
    }

    protected boolean isAgedBrie() {
        return false;
    }

    protected boolean isBackstagePass() {
        return false;
    }

    public void passOneDay() {
        updateSellInDays();
        updateQuality();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    protected void updateQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    protected void updateQualityAfterExpiration() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    protected void updateSellInDays() {
        sellIn = sellIn - 1;
    }
}
