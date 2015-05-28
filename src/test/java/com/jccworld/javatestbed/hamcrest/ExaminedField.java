package com.jccworld.javatestbed.hamcrest;

/**
 * Created by john.crossley on 27/05/2015.
 */
public class ExaminedField {
    private final String fieldName;
    private final boolean matching;

    public ExaminedField(final String fieldName, final boolean matching) {
        this.fieldName = fieldName;
        this.matching = matching;
    }

    public String getFieldName() {
        return fieldName;
    }

    public boolean isMatching() {
        return matching;
    }
}
