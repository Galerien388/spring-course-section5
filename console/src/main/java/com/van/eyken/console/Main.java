package com.van.eyken.console;

import com.van.eyken.AppConfig;
import com.van.eyken.MessageGenerator;
import com.van.eyken.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Joël Van Eyken
 * on 24/11/2018
 */
public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Name");

        // create context (container)

        ConfigurableApplicationContext context;
        context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        // call method next() to get a random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

        // get messageGenerator bean from the context (container)
        MessageGenerator messageGenerator
                = context.getBean(MessageGenerator.class);
        log.info("getMainMsg= {}", messageGenerator.getMainMessage());
        log.info("getResultMsg= {}", messageGenerator.getResultMessage());

        // close context (container)
        context.close();

    }
}
