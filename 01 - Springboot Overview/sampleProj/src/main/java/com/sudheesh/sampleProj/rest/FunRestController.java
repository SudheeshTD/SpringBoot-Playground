package com.sudheesh.sampleProj.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    //Expose new Endpoint

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a Hard 5K!";
    }

}
