package com.jccworld.javatestbed;

/**
 * Created by john.crossley on 26/05/2015.
 */
public class EncapsulatedLogic {

    private final Delegate delegate;
    private final Private privateField;

    public EncapsulatedLogic(final Delegate delegate) {
        this.delegate = delegate;
        privateField = new Private("hidden value");
    }

    public void delegatePrivate() {
        delegate.handle(privateField);
    }

}
