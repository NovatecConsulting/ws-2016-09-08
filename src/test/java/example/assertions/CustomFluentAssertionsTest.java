package example.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;
import org.junit.Test;


public class CustomFluentAssertionsTest {

    @Test
    public void usingCustomFluentAssert() {
        MyType foo = new MyType("Hello World!");
        MyAssertions.assertThat(foo).hasValue("Hello World!");
    }

    @Test
    public void usingCustomFluentAssertFailure() {
        MyType bar = new MyType("Hello World!");
        MyAssertions.assertThat(bar).hasValue("Hello Worlds!");
    }

    public static class MyAssertions {

        public static MyTypeAssert assertThat(MyType actual) {
            return new MyTypeAssert(actual);
        }

    }

    public static class MyTypeAssert extends AbstractAssert<MyTypeAssert, MyType> {

        public MyTypeAssert(MyType actual) {
            super(actual, MyTypeAssert.class);
        }

        public MyTypeAssert hasValue(String expected) {
            assertThat(actual.getValue()).describedAs("value").isEqualTo(expected);
            return this;
        }

    }

}
