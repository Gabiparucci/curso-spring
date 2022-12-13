package br.com.gabi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/sum/{a}/{b}")
    public int sum(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @GetMapping("/substract")
    public int substract(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a-b;
    }
}
