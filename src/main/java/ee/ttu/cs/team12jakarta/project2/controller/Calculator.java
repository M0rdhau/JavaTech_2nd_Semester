package ee.ttu.cs.team12jakarta.project2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

    @GetMapping(value = "/")
    public String index(){
        return "Hello from the other side";
    }
}
