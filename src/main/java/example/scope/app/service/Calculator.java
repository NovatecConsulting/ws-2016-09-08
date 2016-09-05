package example.scope.app.service;

import org.springframework.stereotype.Service;


@Service
public class Calculator {

    public long add(long a, long b) {
        return Math.addExact(a, b);
    }

}
