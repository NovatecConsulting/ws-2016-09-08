package example.scope.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class CalculatorTest {

    Calculator cut = new Calculator();

    @Test
    public void adding_0_and_0_returns_0() {
        long result = cut.add(0L, 0L);
        assertThat(result).isEqualTo(0L);
    }

    @Test
    public void adding_0_and_1_returns_1() {
        long result = cut.add(0L, 1L);
        assertThat(result).isEqualTo(1L);
    }

    @Test
    public void adding_1_and_0_returns_1() {
        long result = cut.add(1L, 0L);
        assertThat(result).isEqualTo(1L);
    }

    @Test
    public void adding_0_and_minus_1_returns_minus_1() {
        long result = cut.add(0L, -1L);
        assertThat(result).isEqualTo(-1L);
    }

    @Test
    public void adding_minus_1_and_0_returns_minus_1() {
        long result = cut.add(-1L, 0L);
        assertThat(result).isEqualTo(-1L);
    }

    @Test
    public void adding_minus_1_and_1_returns_0() {
        long result = cut.add(-1L, 1L);
        assertThat(result).isEqualTo(0L);
    }

    @Test
    public void adding_long_min_and_plus_long_max_returns_minus_1() {
        long result = cut.add(Long.MIN_VALUE, Long.MAX_VALUE);
        assertThat(result).isEqualTo(-1L);
    }

    @Test(expected = ArithmeticException.class)
    public void adding_long_max_and_1_throws_exception() {
        cut.add(Long.MAX_VALUE, 1L);
    }

    @Test(expected = ArithmeticException.class)
    public void adding_long_min_and_minus_1_throws_exception() {
        cut.add(Long.MIN_VALUE, -1L);
    }

}
