package example.scope.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import example.scope.app.service.Calculator;


public class CalculatorControllerTest {

    Calculator calculator;
    CalculatorController cut;

    @Before
    public void setUp() {
        calculator = mock(Calculator.class);
        cut = new CalculatorController(calculator);
    }

    @Test
    public void calculatorServiceIsInvokedToHandleRequest() {
        when(calculator.add(42L, 1337L)).thenReturn(1379L);
        Long result = cut.add(42L, 1337L);
        assertThat(result).isEqualTo(1379L);
    }

}
