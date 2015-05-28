package com.jccworld.javatestbed.matchers;

import com.jccworld.javatestbed.Customer;
import com.jccworld.javatestbed.hamcrest.DescriptiveTypeSafeDiagnosingMatcher;
import com.jccworld.javatestbed.hamcrest.ExaminedField;
import com.jccworld.javatestbed.hamcrest.HamcrestWiring;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by john.crossley on 27/05/2015.
 */
public class CustomerMatcher extends DescriptiveTypeSafeDiagnosingMatcher<Customer> {

    private final Customer actual;

    private final Map<String, ExaminedField> examinedFields = new LinkedHashMap<String, ExaminedField>();

    public CustomerMatcher(final Customer actual) {
        this.actual = actual;
    }

    public boolean matchesSafely(final Customer expected, final Description mismatchDescription) {
        examinedFields.put("title", new ExaminedField(actual.getTitle(), actual.getTitle().equals(expected.getTitle())));
        examinedFields.put("firstName", new ExaminedField(expected.getFirstName(), actual.getFirstName().equals(expected.getFirstName())));
        examinedFields.put("lastName", new ExaminedField(expected.getLastName(), actual.getLastName().equals(expected.getLastName())));

        final String description = HamcrestWiring.generateDescription(actual.getClass(), examinedFields);

        mismatchDescription.appendText(description);

        return HamcrestWiring.countFails(examinedFields) == 0;
    }

    @Override
    public void describeTo(final Description desc) {
        desc.appendText(describe(actual));
    }

    @Override
    public String describe(final Customer customer) {
        return "Customer {"+
                    "title = " + customer.getTitle() + ", " +
                    "firstName = " + customer.getFirstName() + ", " +
                    "lastName = " + customer.getLastName() +
                "}";
    }
}