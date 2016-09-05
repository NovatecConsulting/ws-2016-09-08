package example.scope.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.scope.app.service.Calculator;


@RestController
@RequestMapping("/calc")
public class CalculatorController {

    private Calculator calculator;

    @Autowired
    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Long add(@RequestParam("a") Long a, @RequestParam("b") Long b){
        return calculator.add(a, b);
    }

}
