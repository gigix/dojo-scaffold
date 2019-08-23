package com.gildedrose;

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.base.Charsets.UTF_8;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GildedRoseSafetyNet {
    @Test
    public void should_always_generate_the_same_output() throws IOException {
        File baselineFile = new File("src/test/baseline.txt");
        String baseline = Files.toString(baselineFile, UTF_8);
        assertThat(TextTestFixture.overallTestResult(3), is(baseline));
    }
}
