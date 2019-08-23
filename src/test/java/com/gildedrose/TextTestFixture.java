package com.gildedrose;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.PrintStream;

import static com.gildedrose.Item.*;

public class TextTestFixture {
    public static void main(String[] args) {
        String output = overallTestResult(3);
        System.out.println(output);
    }

    public static String overallTestResult(int days) {
        ByteOutputStream out = new ByteOutputStream();
        PrintStream outputStream = new PrintStream(out);

        outputStream.println("OMGHAI!");

        Item[] items = new Item[]{
                createNormalItem("+5 Dexterity Vest", 10, 20), //
                createAgedBrie(2, 0), //
                createNormalItem("Elixir of the Mongoose", 5, 7), //
                createSulfuras(0, 80), //
                createSulfuras(-1, 80),
                createBackstagePass(15, 20),
                createBackstagePass(10, 49),
                createBackstagePass(5, 49),
                // this conjured item does not work properly yet
                createNormalItem("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            outputStream.println("-------- day " + i + " --------");
            outputStream.println("name, sellIn, quality");
            for (Item item : items) {
                outputStream.println(item);
            }
            outputStream.println();
            app.passOneDay();
        }

        return out.toString();
    }

}
