package com.sudheesh.example.springcore.config;

import com.sudheesh.example.springcore.common.Coach;
import com.sudheesh.example.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();

    }

}
