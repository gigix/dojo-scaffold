package org.codingdojo.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RowTest {
    @Test
    public void should_create_a_row_grids() {
        Row row = new Row(3, 0);
        assertThat(row.size(), is(3));
        assertThat(row.head().toString(), is("0 0"));
        assertThat(row.head().right().toString(), is("1 0"));
    }

    @Test
    public void should_link_to_another_row() {
        Row one = new Row(3, 0);
        Row another = new Row(3, 1);
        one.upLinkTo(another);

        Grid head = one.head();
        assertThat(head.toString(), is("0 0"));
        assertThat(head.above().toString(), is("0 1"));
        assertThat(head.above().below(), is(head));
    }
}
