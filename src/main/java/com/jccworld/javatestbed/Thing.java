package com.jccworld.javatestbed;

/**
 * Created by john.crossley on 26/05/2015.
 */
public class Thing {

    private final NumberGenerator numberGenerator;

    public Thing(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public String generateCustomId() {
        return "X" + numberGenerator.getNumber();
    }
}
