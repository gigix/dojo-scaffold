import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void should_be_able_to_run_a_trivial_test_case() {
        assertThat(Calculator.add(1, 1), is(2));
    }
}
