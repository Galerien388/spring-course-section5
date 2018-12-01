package com.van.eyken;

import java.util.Random;

/**
 * Created by Joël Van Eyken
 * on 24/11/2018
 */

public class NumberGeneratorImpl implements NumberGenerator {

    //<editor-fold desc="Fiels">
    private Random random = new Random();
    private int maxNumber = 100;
    //</editor-fold>

    //<editor-fold desc="public methods">
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
    //</editor-fold>
}
