package com.familyfirstsoftware.departmentManager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {

    // pulled from application.properties
    @Value("${welcome.message}")
    private String welcomeMessage;


    // when you go to / with a get request return "hello"
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    // same as
    @GetMapping("/")
    public String sayHello(){

        return welcomeMessage;
    }

}
