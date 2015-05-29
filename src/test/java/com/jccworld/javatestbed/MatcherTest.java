package com.jccworld.javatestbed;

import com.jccworld.javatestbed.matchers.CustomerMatcher;
import com.jccworld.javatestbed.matchers.FluentCustomerMatcher;
import com.jccworld.javatestbed.matchers.ItemMatcher;
import com.jccworld.javatestbed.matchers.TransactionMatcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.jccworld.javatestbed.matchers.CustomerFirstNameFeatureMatcher.aCustomerWith;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.verify;

/**
 * User: jcc
 * Date: 24/05/15
 */
public class MatcherTest {
    @Mock private Delegate mockDelegate;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

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

    @Test
    public void squashMatcherIntoMockitoWithArgThat() {
        // init
        final Transaction expected = new Transaction(new Customer("Mr", "John", "Crossley"), new Item("x123", "Jane Doe"));
        PhonySut sut = new PhonySut(mockDelegate);

        // run
        sut.doIt(expected);

        // verify
        verify(mockDelegate).handle(argThat(new TransactionMatcher(expected)));
    }

    @Test
    public void featureMatcherTest() {
        // init
        final Customer customer = new Customer("Mr", "John", "Crossley");

        // verify
        assertThat(customer, aCustomerWith("Johnny"));
    }

    @Test
    public void multiItemFeatureMatcherTest() {
        // init
        final Customer customer = new Customer("Mr", "John", "Crossley");

        // verify
        assertThat(customer, new FluentCustomerMatcher().withTitle("Mr ").withFirstName("Johnny").withLastName("Crossleyy"));
    }

    /**
     * Simple class to examine test where a object passed through is equal via a matcher.
     */
    public class PhonySut {
        private final Delegate delegate;

        public PhonySut(final Delegate delegate) {
            this.delegate = delegate;
        }

        public void doIt(final Transaction transaction) {
            delegate.handle(transaction);
        }
    }
}
