package com.sudheesh.example.springcore.rest;

import com.sudheesh.example.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    /*
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }
    */

    /*
    @Autowired
    public void randomcoachfunc(Coach thecoach) {
        myCoach =  thecoach;
    }
    */

    @Autowired
    public void setCoach(Coach thecoach) {
        myCoach =  thecoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }



}
