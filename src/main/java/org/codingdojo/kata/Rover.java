package org.codingdojo.kata;

import java.util.Arrays;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.valueOf;

public class Rover {
    private Integer x;
    private Integer y;
    private String direction;

    public Rover(String initialStatus) {
        String[] status = initialStatus.split(" ");
        x = valueOf(status[0]);
        y = valueOf(status[1]);
        direction = status[2];
    }

    public String status() {
        return x + " " + y + " " + direction;
    }

    public void on(String demand) {
        if ("l".equalsIgnoreCase(demand)) {
            switch (direction) {
                case "w":
                    direction = "s";
                    break;
                case "s":
                    direction = "e";
                    break;
                case "e":
                    direction = "n";
                    break;
                case "n":
                    direction = "w";
                    break;
            }
        }

        if ("r".equalsIgnoreCase(demand)) {
            switch (direction) {
                case "w":
                    direction = "n";
                    break;
                case "n":
                    direction = "e";
                    break;
                case "e":
                    direction = "s";
                    break;
                case "s":
                    direction = "w";
                    break;
            }
        }

        if ("f".equalsIgnoreCase(demand)) {
            switch (direction) {
                case "w":
                    x--;
                    break;
                case "s":
                    y--;
                    break;
                case "e":
                    x++;
                    break;
                case "n":
                    y++;
                    break;
            }
        }
    }

    void execute(String statement) {
        newArrayList(statement.split("(?!^)")).forEach(cmd -> on(cmd));
    }
}
