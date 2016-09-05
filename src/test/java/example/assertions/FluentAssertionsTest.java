package example.assertions;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;


public class FluentAssertionsTest {

    @Test
    public void fluentAssertionsDemo1() {
        Integer someNumber = 1000;
        assertThat(someNumber)
            .isNotNull()
            .isGreaterThan(999)
            .isLessThan(1001)
            .isEqualTo(1000);
    }

    @Test
    public void fluentAssertionsDemo2() {
        List<String> values = asList("foo", "bar");
        assertThat(values)
            .isNotNull()
            .contains("foo", "bar")
            .doesNotContain("xur")
            .hasSize(2);
    }

}
