package example.assertions;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;


public class CustomMatcherAssertionsTest {

    @Test
    public void usingCustomFluentAssert() {
        MyType foo = new MyType("Hello World!");
        assertThat(foo, MyMatchers.hasValue("Hello World!"));
    }

    @Test
    public void usingCustomFluentAssertFailure() {
        MyType bar = new MyType("Hello World!");
        assertThat(bar, MyMatchers.hasValue("Hello Worlds!"));
    }

    public static class MyMatchers {

        public static MyTypeValueMatcher hasValue(String expected) {
            return new MyTypeValueMatcher(expected);
        }

    }

    public static class MyTypeValueMatcher extends TypeSafeMatcher<MyType> {

        private final String expected;

        public MyTypeValueMatcher(String expected) {
            this.expected = expected;
        }

        @Override
        protected boolean matchesSafely(MyType item) {
            return expected.equals(item.getValue());
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("value of <" + expected + ">");
        }

        @Override
        protected void describeMismatchSafely(MyType item, Description mismatchDescription) {
            mismatchDescription.appendText("was <" + item.getValue() + ">");
        }

    }

}
