package example.scope.app.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import example.scope.app.service.Calculator;


@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerIntTest {

    @MockBean
    private Calculator calculator;

    @Autowired
    private MockMvc mvc;

    @Test
    public void endpointReturnsCalculationFromService() throws Exception {
        when(calculator.add(42L, 1337L)).thenReturn(1379L);
        mvc.perform(get("/calc/add").param("a", "42").param("b", "1337"))
            .andExpect(status().is(200))
            .andExpect(content().string("1379"));
    }

    @Test
    public void missingParameterLeadsToBadRequest() throws Exception {
        when(calculator.add(42L, 1337L)).thenReturn(1379L);
        mvc.perform(get("/calc/add").param("a", "42")).andExpect(status().is(400));
    }

}
