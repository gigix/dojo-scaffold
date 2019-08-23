package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras extends Item {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    protected boolean isSulfuras() {
        return true;
    }
}
