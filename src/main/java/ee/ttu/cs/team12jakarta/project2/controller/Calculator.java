package ee.ttu.cs.team12jakarta.project2.controller;

import ee.ttu.cs.team12jakarta.project2.dto.CalculatorResult;
import ee.ttu.cs.team12jakarta.project2.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("calculator")
public class Calculator {

    @Autowired
    private CalculatorService calcService;

    @GetMapping(value = "/")
    public String index() {
        return "Hello from the other side";
    }

    @GetMapping(value = "/calculate1", produces = "application/json")
    public CalculatorResult calculate1(@RequestParam List<Integer> input) {
        return calcService.calculateOne(input);
    }
}
