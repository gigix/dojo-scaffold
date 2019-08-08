package org.codingdojo.kata.args;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

public class Args {
    private final List<Arg> args;

    public Args(Schema schema, String... texts) {
        args = newArrayList(texts).stream().map(text -> new Arg(text, schema)).collect(toList());
    }

    public int size() {
        return args.size();
    }

    public Object valueOf(String label) {
        return args.stream().filter(arg -> arg.label.equals(label)).findAny().get().value();
    }
}
