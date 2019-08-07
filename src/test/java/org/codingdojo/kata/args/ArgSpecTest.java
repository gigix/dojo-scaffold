package org.codingdojo.kata.args;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArgSpecTest {
    @Test
    public void should_create_arg_spec_out_of_text_representation() {
        ArgSpec argSpec = new ArgSpec("l:boolean");
        assertThat(argSpec.label, is("l"));
        assertThat(argSpec.type, is("boolean"));
    }
}