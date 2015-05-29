package com.jccworld.javatestbed.matchers;

import com.jccworld.javatestbed.Customer;
import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by john.crossley on 29/05/2015.
 */
public class FluentCustomerMatcher extends TypeSafeDiagnosingMatcher<Customer> {

    final List<Matcher> matchers = new ArrayList<Matcher>();

    public FluentCustomerMatcher withTitle(final String title) {
        matchers.add(new FeatureMatcher<Customer, String>(equalTo(title), "with title", "title") {
            @Override
            protected String featureValueOf(Customer customer) {
                return customer.getTitle();
            }
        });
        return this;
    }

    public FluentCustomerMatcher withFirstName(final String firstName) {
        matchers.add(new FeatureMatcher<Customer, String>(equalTo(firstName), "with firstName", "firstName") {
            @Override
            protected String featureValueOf(Customer customer) {
                return customer.getFirstName();
            }
        });
        return this;
    }

    public FluentCustomerMatcher withLastName(final String lastName) {
        matchers.add(new FeatureMatcher<Customer, String>(equalTo(lastName), "with lastName", "lastName") {
            @Override
            protected String featureValueOf(Customer customer) {
                return customer.getLastName();
            }
        });
        return this;
    }

    @Override
    protected boolean matchesSafely(Customer customer, Description description) {
        boolean allOk = true;
        for(Matcher<Customer> matcher : matchers) {
            if (!matcher.matches(customer)) {
                allOk = false;//keep going as we want all values put into the description
                matcher.describeMismatch(customer, description);
                description.appendText(" ");
            }
        }

        return allOk;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Customer");
        description.appendList("{", " ", "}", matchers);
    }
}