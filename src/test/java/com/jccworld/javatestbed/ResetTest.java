package com.jccworld.javatestbed;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * User: jcc
 * Date: 24/05/15
 */
public class ResetTest {
    private static final java.lang.Integer A_VALID_NUMBER = 42;

    @Mock private NumberGenerator mockNumberGenerator;

    private Thing sut;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sut = new Thing(mockNumberGenerator);
    }

    @Test
    public void secondRequestIsDifferent() {
        // init
        when(mockNumberGenerator.getNumber()).thenReturn(A_VALID_NUMBER);
        final String result1 = sut.generateCustomId();
        reset(mockNumberGenerator);

        // run
        final String result2 = sut.generateCustomId();

        // verify
        assertNotEquals(result1, result2);
        verify(mockNumberGenerator).getNumber();
    }
}
