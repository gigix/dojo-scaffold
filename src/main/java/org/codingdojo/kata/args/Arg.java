package org.codingdojo.kata.args;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Arg {
    public final String label;
    private final String rawValue;
    private final ArgSpec argSpec;

    public Arg(String text, Schema schema) {
        label = text.split(" ")[0].replaceFirst("-", "");
        rawValue = text.split(" ")[1];
        argSpec = schema.specOf(label);
    }

    public Object value() {
        if (argSpec.isTypeOf("boolean")) {
            return parseBoolean(rawValue);
        }
        if(argSpec.isTypeOf("integer")) {
            return parseInt(rawValue);
        }
        return rawValue;
    }

}
