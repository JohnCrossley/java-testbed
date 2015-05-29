package com.jccworld.javatestbed.matchers;

import com.jccworld.javatestbed.Customer;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by john.crossley on 29/05/2015.
 */
public class CustomerFirstNameFeatureMatcher extends FeatureMatcher<Customer, String> {

    public static FeatureMatcher<Customer, String> aCustomerWith(final String firstName) {
        return new CustomerFirstNameFeatureMatcher(equalTo(firstName), "a customer with firstName", "firstName") {
            @Override
            protected String featureValueOf(final Customer customer) {
                return customer.getFirstName();
            }
        };
    }

    private CustomerFirstNameFeatureMatcher(Matcher<? super String> subMatcher, String featureDescription, String featureName) {
        super(subMatcher, featureDescription, featureName);
    }

    @Override
    protected String featureValueOf(final Customer customer) {
        return customer.getFirstName();
    }
}