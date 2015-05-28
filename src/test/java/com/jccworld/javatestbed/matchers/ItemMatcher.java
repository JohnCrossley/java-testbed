package com.jccworld.javatestbed.matchers;

import com.jccworld.javatestbed.Item;
import com.jccworld.javatestbed.hamcrest.DescriptiveTypeSafeDiagnosingMatcher;
import com.jccworld.javatestbed.hamcrest.ExaminedField;
import com.jccworld.javatestbed.hamcrest.HamcrestWiring;
import org.hamcrest.Description;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by john.crossley on 27/05/2015.
 */
public class ItemMatcher extends DescriptiveTypeSafeDiagnosingMatcher<Item> {

    private final Item actual;

    private final Map<String, ExaminedField> examinedFields = new LinkedHashMap<String, ExaminedField>();

    public ItemMatcher(final Item actual) {
        this.actual = actual;
    }

    @Override
    public boolean matchesSafely(final Item expected, final Description mismatchDescription) {
        examinedFields.put("id", new ExaminedField(actual.getId(), actual.getId().equals(expected.getId())));
        examinedFields.put("name", new ExaminedField(expected.getName(), actual.getName().equals(expected.getName())));

        final String description = HamcrestWiring.generateDescription(actual.getClass(), examinedFields);

        mismatchDescription.appendText(description);

        return HamcrestWiring.countFails(examinedFields) == 0;
    }

    public void describeTo(final Description desc) {
        desc.appendText(describe(actual));
    }

    @Override
    public String describe(final Item item) {
        return "Item {" +
                    "id = " + item.getId() + ", " +
                    "name = " + item.getName() +
                "}";
    }
}