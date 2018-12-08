package com.van.eyken.console;

import com.van.eyken.Game;
import com.van.eyken.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Create by Joêl Van Eyken
 * on 08/12/2018
 */
@Component
public class ConsoleNumberGuess {    // implements ApplicationListener<ContextRefreshedEvent> {  // can be replaced  by annotation EventListener

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

    @Autowired
    public ConsoleNumberGuess(MessageGenerator messageGenerator,Game game) {
        this.messageGenerator = messageGenerator;
        this.game = game;
    }

    // == events ==
    @EventListener
    public void start (ContextRefreshedEvent contextRefreshedEvent) { // method can now be renamed : onApplicationEvent to start
        log.info("Container ready for use");
    }

    // insteadof parameter contextRefreshedEvent , we can do this as argument in the annotation
    @EventListener(ContextRefreshedEvent.class)
    public void start2(){
        log.info("Container ready for use second way");
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();

            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n");

                String playAgainString = scanner.nextLine().trim();

                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }

                game.reset();
            }

        }
    }
}
