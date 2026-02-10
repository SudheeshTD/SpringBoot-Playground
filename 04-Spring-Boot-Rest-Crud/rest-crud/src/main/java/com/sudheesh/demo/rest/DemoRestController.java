package com.sudheesh.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    //Add Hello Endpoint

    @GetMapping("/hello")
    public String sayHello(){
        return "hello world";
    }

}
