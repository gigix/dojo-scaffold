package org.codingdojo.kata.args;

public class ArgSpec {
    public String label;
    public String type;

    public ArgSpec(String pair) {
        label = pair.split(":")[0];
        type = pair.split(":")[1];
    }
}
