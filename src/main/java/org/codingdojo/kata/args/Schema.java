package org.codingdojo.kata.args;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

public class Schema {
    private final List<ArgSpec> argSpecs;

    public Schema(String text) {
        argSpecs = newArrayList(text.split(" ")).stream().map(ArgSpec::new).collect(toList());
    }

    public int size() {
        return argSpecs.size();
    }

    public String typeOf(String label) {
        return argSpecs.stream().filter(argSpec -> argSpec.label.equals(label)).findFirst().get().type;
    }
}
