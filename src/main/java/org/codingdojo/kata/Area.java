package org.codingdojo.kata;

import static java.lang.Integer.valueOf;

public class Area {
    public final Integer x;
    public final Integer y;

    public Area(String text) {
        String[] numberPair = text.split(" ");
        x = valueOf(numberPair[0]);
        y = valueOf(numberPair[1]);
    }

    public Rover deploy(String coordinate) {
        return new Rover(coordinate);
    }
}
