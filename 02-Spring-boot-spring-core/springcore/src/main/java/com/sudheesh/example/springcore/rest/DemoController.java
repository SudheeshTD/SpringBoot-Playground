package com.sudheesh.example.springcore.rest;

import com.sudheesh.example.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    private Coach myCoach;

    //private Coach anotherCoach;

//    @Autowired
//    public DemoController(@Qualifier("cricketCoach")Coach theCoach // ,
////                          @Qualifier("cricketCoach")Coach theAnotherCoach
//    ){
//        System.out.println("In constructor: " +  getClass().getSimpleName());
//        myCoach = theCoach;
//        //anotherCoach = theAnotherCoach;
//    }

        @Autowired
        public DemoController(@Qualifier("aquatic")Coach theCoach) {
            System.out.println("In constructor: " + getClass().getSimpleName());
            myCoach = theCoach;
        }


//    @GetMapping("/check")
//    public String check(){
//        return "Comparing beans: mycoach === anotherCoach, " + (myCoach == anotherCoach);
//    }


    /*
    @Autowired
    public void randomcoachfunc(Coach thecoach) {
        myCoach =  thecoach;
    }
    */
/*
    @Autowired
    public void setCoach(Coach thecoach) {
        myCoach =  thecoach;
    }
*/
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }



}
