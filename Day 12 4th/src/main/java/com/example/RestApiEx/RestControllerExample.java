package com.example.RestApiEx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestControllerExample {
    @RequestMapping("/hello")
    public String display(){
        return "Hello RestFull API";
    }
    @RequestMapping("/hi")
    public String show(){
        return "Hi";
    }
}
