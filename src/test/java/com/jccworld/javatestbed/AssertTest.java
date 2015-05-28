package com.jccworld.javatestbed;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: jcc
 * Date: 24/05/15
 */
public class AssertTest {
    private static final String A_VALID_TITLE = "a valid title";
    private static final String A_VALID_FIRST_NAME = "a valid first name";
    private static final String A_VALID_LAST_NAME = "a valid last name";

    private Customer sut;

    @Before
    public void setUp() throws Exception {
        sut = new Customer(A_VALID_TITLE, A_VALID_FIRST_NAME, A_VALID_LAST_NAME);
    }

    @Test
    public void reportsTheCorrectName() {
        // init
        String expected = A_VALID_TITLE + " " + A_VALID_FIRST_NAME + " " + A_VALID_LAST_NAME;

        // run
        String result = sut.getName();

        // verify
        assertEquals(expected, result);
    }
}
