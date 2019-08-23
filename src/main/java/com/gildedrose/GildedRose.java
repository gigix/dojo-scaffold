package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void passesOneDay() {
        for (Item item : items) {
            item.updateQualityAndSellInDays();
        }
    }

}