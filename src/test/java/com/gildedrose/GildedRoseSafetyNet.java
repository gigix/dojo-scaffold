package com.gildedrose;

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.gildedrose.TextTestFixture.generateBaselineOutput;
import static com.google.common.base.Charsets.UTF_8;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GildedRoseSafetyNet {
    @Test
    public void should_always_generate_output_identical_to_baseline() throws IOException {
        String baseline = Files.toString(new File("src/test/baseline.txt"), UTF_8);
        assertThat(generateBaselineOutput(), is(baseline));
    }
}
