package com.jccworld.javatestbed.matchers;

import com.jccworld.javatestbed.Transaction;
import com.jccworld.javatestbed.hamcrest.ExaminedField;
import com.jccworld.javatestbed.hamcrest.HamcrestWiring;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by john.crossley on 27/05/2015.
 */
public class TransactionMatcher extends TypeSafeDiagnosingMatcher<Transaction> {

    private final Transaction actual;
    private final CustomerMatcher customerMatcher;
    private final ItemMatcher itemMatcher;

    private final Map<String, ExaminedField> examinedFields = new LinkedHashMap<String, ExaminedField>();

    public TransactionMatcher(final Transaction actual) {
        this.actual = actual;
        customerMatcher = new CustomerMatcher(actual.getCustomer());
        itemMatcher = new ItemMatcher(actual.getItem());
    }

    public boolean matchesSafely(final Transaction expected, Description mismatchDescription) {
        examinedFields.put("customer", new ExaminedField(customerMatcher.describe(actual.getCustomer()), customerMatcher.matches(expected.getCustomer())));
        examinedFields.put("item", new ExaminedField(itemMatcher.describe(actual.getItem()), itemMatcher.matches(expected.getItem())));

        final String description = HamcrestWiring.generateDescription(actual.getClass(), examinedFields);

        mismatchDescription.appendText(description);

        return HamcrestWiring.countFails(examinedFields) == 0;
    }

    public void describeTo(Description desc) {
        desc.appendText("Transaction {")
                .appendText("customer = " + customerMatcher.describe(actual.getCustomer()) + ", ")
                .appendText("item = " + itemMatcher.describe(actual.getItem()))
                .appendText("}");
    }
}