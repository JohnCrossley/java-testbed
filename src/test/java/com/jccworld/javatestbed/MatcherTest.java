package com.jccworld.javatestbed;

import com.jccworld.javatestbed.matchers.CustomerMatcher;
import com.jccworld.javatestbed.matchers.ItemMatcher;
import com.jccworld.javatestbed.matchers.TransactionMatcher;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * User: jcc
 * Date: 24/05/15
 */
public class MatcherTest {
    @Test
    public void checksCustomerIsCreatedCorrectly() {
        // init
        final Customer expected = new Customer("Mr", "John", "Crossley");

        // run
        assertThat(expected, new CustomerMatcher(new Customer("Mr", "Johnx", "Crossley")));
    }

    @Test
    public void checksItemIsCreatedCorrectly() {
        // init
        final Item expected = new Item("x123", "Jane Doe");

        // run
        assertThat(expected, new ItemMatcher(new Item("x123", "Jim Doe")));
    }

    @Test
    public void combined() {
        // init
        final Transaction expected = new Transaction(new Customer("Mr", "John", "Crossley"), new Item("x123", "Jane Doe"));

        // verify
        assertThat(expected, new TransactionMatcher(new Transaction(new Customer("Mr", "John-", "Crossley"), new Item("x123-", "Jane Doe"))));
    }
}
