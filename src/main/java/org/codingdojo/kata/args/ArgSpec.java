package org.codingdojo.kata.args;

public class ArgSpec {
    public final String label;
    public final String type;

    public ArgSpec(String text) {
        label = text.split(":")[0];
        type = text.split(":")[1];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ArgSpec)) {
            return false;
        }
        ArgSpec another = (ArgSpec) obj;
        return this.label.equals(another.label) && this.type.equals(another.type);
    }

    @Override
    public int hashCode() {
        return label.hashCode() + type.hashCode();
    }

    public boolean isTypeOf(String type) {
        return this.type.equals(type);
    }

    public boolean isOfLabel(String label) {
        return this.label.equals(label);
    }
}
