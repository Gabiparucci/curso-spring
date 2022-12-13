package br.com.gabi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping(path = "/hello")
    public String ola() {
        return "Hello Spring!";
    }
}
