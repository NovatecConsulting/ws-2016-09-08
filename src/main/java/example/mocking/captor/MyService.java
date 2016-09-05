package example.mocking.captor;

public class MyService {

    private final MyOtherService service;

    public MyService(MyOtherService service) {
        this.service = service;
    }

    public void doSomething(String value) {

        // ... do something

        MyType wrappedValue = new MyType(value);
        service.handle(wrappedValue);

        // ... do something more

    }

}
