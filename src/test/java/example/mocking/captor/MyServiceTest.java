package example.mocking.captor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;


public class MyServiceTest {

    ArgumentCaptor<MyType> captor;

    MyOtherService otherService;
    MyService cut;

    @Before
    public void setUp() {
        captor = ArgumentCaptor.forClass(MyType.class);
        otherService = mock(MyOtherService.class);
        cut = new MyService(otherService);
    }

    @Test
    public void captureOtherwiseUnreachableArguments() {

        cut.doSomething("Hello World!");
        verify(otherService).handle(captor.capture());

        MyType wrappedValue = captor.getValue();
        assertThat(wrappedValue.getValue()).isEqualTo("Hello World!");

    }

}
