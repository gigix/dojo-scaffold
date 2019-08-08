package org.codingdojo.kata.args;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArgSpecTest {
    @Test
    public void should_create_arg_spec_out_of_text() {
        ArgSpec argSpec = new ArgSpec("l:boolean");
        assertThat(argSpec.label, is("l"));
        assertThat(argSpec.type, is("boolean"));
    }

    @Test
    public void should_support_literal_equality() {
        assertThat(new ArgSpec("l:boolean"), is(new ArgSpec("l:boolean")));
    }
}