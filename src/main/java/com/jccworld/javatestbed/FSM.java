package com.jccworld.javatestbed;

/**
 * Created by john.crossley on 26/05/2015.
 */
public class FSM {

    private int lastNumber;

    private final NumberGenerator numberGenerator;

    public FSM(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public String doIt() {
        lastNumber = numberGenerator.getNumber();
        stop();
        return "X" + lastNumber;
    }

    public void stop() {

    }
}
