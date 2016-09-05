package example.assertions;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.Test;


public class AssertionTraps {

    /* Hiding information by using redundant assertions and failing early. */

    @Test
    public void redundantSizeCheck() {
        List<String> values = asList("foo", "bar");
        assertThat(values).containsExactly("foo", "bar", "xur");
    }

    @Test
    public void redundantSizeCheck_hidden1() {
        List<String> values = asList("foo", "bar");
        assertThat(values).hasSize(3).containsExactly("foo", "bar", "xur");
    }

    @Test
    public void redundantSizeCheck_hidden2() {
        List<String> values = asList("foo", "bar");
        assertThat(values, hasSize(3));
        assertThat(values, contains("foo", "bar", "xur"));
    }

}
