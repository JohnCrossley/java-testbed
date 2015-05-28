package com.jccworld.javatestbed.hamcrest;

import java.util.Map;

/**
 * Hamcrest is designed to describe only the first error.  This extends the functionality to print all matcher results.
 *
 * Created by john.crossley on 27/05/2015.
 */
public class HamcrestWiring {
    public static int countFails(final Map<String, ExaminedField> examinedFieldMap) {
        int fails = 0;
        for(final ExaminedField examinedField : examinedFieldMap.values()) {
            if (!examinedField.isMatching()) {
                fails++;
            }
        }

        return fails;
    }

    /**
     * Creates a pretty error string with fields that don't match prepended with an asterisk *.
     *
     * ClazzSimpleName { [*]field1, ... }
     *
     * I.e. Customer {title = Mr, *firstName = John, lastName = Crossley}
     *
     * @param clazz
     * @param examinedFieldMap
     * @return
     */
    public static String generateDescription(final Class clazz, final Map<String, ExaminedField> examinedFieldMap) {
        StringBuilder builder = new StringBuilder(clazz.getSimpleName() + " {");
        int i = 0;
        for(String key : examinedFieldMap.keySet()) {
            if (!examinedFieldMap.get(key).isMatching()) {
                builder.append("*");
            }

            builder.append(key + " = " + examinedFieldMap.get(key).getFieldName());

            builder.append((i++ == examinedFieldMap.size() - 1) ? "" : ", ");
        }
        builder.append("}");

        return builder.toString();
    }
}
