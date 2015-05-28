package com.jccworld.javatestbed;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class StubbingTest {

    private static final java.lang.Integer A_VALID_NUMBER = 42;

    @Mock private NumberGenerator mockNumberGenerator;

    private Thing sut;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sut = new Thing(mockNumberGenerator);
    }

    @Test
    public void usesNumberGeneratorToCreateCustomId() {
        // init
        final String expected = "X" + A_VALID_NUMBER;
        when(mockNumberGenerator.getNumber()).thenReturn(A_VALID_NUMBER);

        // run
        final String result = sut.generateCustomId();

        // verify
        assertEquals(expected, result);
    }

}