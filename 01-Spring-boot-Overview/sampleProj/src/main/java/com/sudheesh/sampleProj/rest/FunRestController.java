package com.sudheesh.sampleProj.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject Properties: Coach Name and team Name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+ coachName+"\nTeam: "+teamName; 
    }

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
