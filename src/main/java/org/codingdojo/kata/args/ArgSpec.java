package org.codingdojo.kata.args;

public class ArgSpec {
    public String label;
    public String type;

    public ArgSpec(String text) {
        label = text.split(":")[0];
        type = text.split(":")[1];
    }
}
