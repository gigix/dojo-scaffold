package org.codingdojo.kata.args;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Arg {
    private final String label;
    private final String rawValue;
    private final ArgSpec argSpec;

    public Arg(Schema schema, String text) {
        label = text.split(" ")[0].replaceFirst("-", "");
        rawValue = text.split(" ")[1];
        argSpec = schema.specOf(label);
    }

    public Object value() {
        switch (argSpec.type) {
            case "boolean":
                return parseBoolean(rawValue);
            case "integer":
                return parseInt(rawValue);
            case "[string]":
                return newArrayList(rawValue.split(","));
            default:
                return rawValue;
        }
    }

    public boolean withLabel(String label) {
        return this.label.equals(label);
    }
}
