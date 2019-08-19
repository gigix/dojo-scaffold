package org.codingdojo.kata.args;

import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

public class Schema {
    private final List<ArgSpec> argSpecs;
    private String rawText;

    public Schema(String text) {
        argSpecs = newArrayList(text.split(" ")).stream().map(ArgSpec::new).collect(toList());
        rawText = text;
        validate();
    }

    private void validate() {
        if(hasLabelDuplication()) {
            throw new InvalidSchema(rawText);
        }
    }

    private boolean hasLabelDuplication() {
        long labelsWithoutDuplication = argSpecs.stream().map(argSpec -> argSpec.label).distinct().count();
        return labelsWithoutDuplication < argSpecs.size();
    }

    public int size() {
        return argSpecs.size();
    }

    public String typeOf(String label) {
        ArgSpec argSpec = specOf(label);
        return argSpec.type;
    }

    public ArgSpec specOf(String label) {
        Optional<ArgSpec> candidate = argSpecs.stream().filter(argSpec -> argSpec.isOfLabel(label)).findAny();
        if (candidate.isEmpty()) {
            throw new LabelNotFound(label);
        }
        return candidate.get();
    }

}
