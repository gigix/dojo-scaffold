package org.codingdojo.kata.args;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArgTest {
    private Schema schema;

    @Before
    public void setUp() {
        schema = new Schema("l:boolean p:integer d:string");
    }

    @Test
    public void should_create_arg_out_of_text() {
        assertThat(new Arg(schema, "-l true").value(), is(true));
        assertThat(new Arg(schema, "-p 8080").value(), is(8080));
        assertThat(new Arg(schema, "-d /usr/log").value(), is("/usr/log"));
    }

    @Test(expected = LabelNotFound.class)
    public void should_reject_undefined_arg() {
        new Arg(schema, "-w 123");
    }

    @Test
    public void should_support_string_array_type() {
        schema = new Schema("s:[string]");
        Arg arg = new Arg(schema, "-s abc,123,xyz");
        assertThat(arg.value(), is(newArrayList("abc", "123", "xyz")));
    }
}