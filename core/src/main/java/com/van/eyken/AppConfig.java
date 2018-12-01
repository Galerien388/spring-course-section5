package com.van.eyken;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Create by Joêl Van Eyken
 * on 01/12/2018
 */
@Configuration
@ComponentScan(basePackages = "com.van.eyken")
public class AppConfig {

    // == bean methods ==

    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }

}
