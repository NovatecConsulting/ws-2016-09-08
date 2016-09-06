package example.practice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class IbanCalculatorTest {

    IbanCalculator cut = new IbanCalculator();

    @Test
    public void germanIbanCanBeGeneratedFromValidInputData() {
        String iban = cut.calculate(CountryCode.DE, "60050101", "7311105725");
        assertThat(iban).isEqualTo("DE41600501017311105725");
    }

}
