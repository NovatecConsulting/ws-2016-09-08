package example.scope.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;


public class ApplicationSysTest {

    static RestTemplate template = new RestTemplate();
    static ConfigurableApplicationContext application;

    @BeforeClass
    public static void startApplication() {
        application = Application.start();
    }

    @AfterClass
    public static void stopApplication() {
        application.stop();
    }

    @Test
    public void addingTwoNumbersIsExecuted(){
        Long result = template.getForObject("http://localhost:8080/calc/add?a=-100&b=200", Long.class);
        assertThat(result).isEqualTo(100L);
    }

}
