package org.codingdojo.kata.args;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Schema {
    private final List<ArgSpec> argSpecs;

    public Schema(String text) {
        argSpecs = newArrayList(text.split(" ")).stream().map(ArgSpec::new).collect(toList());
        validate(text);
    }

    private void validate(String text) {
        Set<String> labelsWithoutDuplicate = argSpecs.stream().map(argSpec -> argSpec.label).collect(toSet());
        if(labelsWithoutDuplicate.size() < argSpecs.size()) {
            throw new InvalidSchema(text);
        }
    }

    public int size() {
        return argSpecs.size();
    }

    public String typeOf(String label) {
        Optional<ArgSpec> candidate = argSpecs.stream().filter(argSpec -> argSpec.label.equals(label)).findAny();
        if (candidate.isEmpty()) {
            throw new LabelNotFound(label);
        }
        return candidate.get().type;
    }
}
