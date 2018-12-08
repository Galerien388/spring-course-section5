package com.van.eyken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Joël Van Eyken
 * on 24/11/2018
 */
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    //<editor-fold desc="Fiels">
    // == fields ==
    private Random random = new Random();

    //@Autowired     now using constructor autowirering
    //@MaxNumber
    private final int maxNumber;

    //@Autowired     now using constructor autowirering
    //@MinNumber
    private final int minNumber;
    //</editor-fold>

    // == constructor ==
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //<editor-fold desc="public methods">
    @Override
    public int next() {
        // example: min=5 max=20 -> max-min=15 -> range 0-15 + min -> 5-20
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }

    //</editor-fold>
}
