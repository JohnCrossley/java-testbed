package com.jccworld.javatestbed.hamcrest;

import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * Created by john.crossley on 28/05/2015.
 */
public abstract class DescriptiveTypeSafeDiagnosingMatcher<T> extends TypeSafeDiagnosingMatcher<T> {

    public abstract String describe(T t);

}
