package com.van.eyken.config;

import com.van.eyken.GuessCount;
import com.van.eyken.MaxNumber;
import com.van.eyken.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Create by Joêl Van Eyken
 * on 08/12/2018
 */
@Configuration
@ComponentScan(basePackages = "com.van.eyken")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber:20}")    // :20 default value
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private  int guessCount;

    @Value("${game.minNumber:0}")
    private int minNumber;

    // == beans methods ==

    @Bean
    @MaxNumber       // by creating this annotation , we can choose a different name for this method
    public int maxNumberDifferentName(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
}
