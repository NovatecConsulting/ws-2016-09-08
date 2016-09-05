package example.assertions;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import java.util.List;

import org.junit.Test;


public class MatcherAssertionsTest {

    @Test
    public void fluentAssertionsDemo1() {
        Integer someNumber = 1000;
        assertThat(someNumber, is(not(nullValue())));
        assertThat(someNumber, is(greaterThan(999)));
        assertThat(someNumber, is(lessThan(1001)));
        assertThat(someNumber, is(equalTo(1000)));
    }

    @Test
    public void fluentAssertionsDemo2() {
        List<String> values = asList("foo", "bar");
        assertThat(values, is(not(nullValue())));
        assertThat(values, contains("foo", "bar"));
        assertThat(values, not(contains("xur")));
        assertThat(values, hasSize(2));
    }

}
