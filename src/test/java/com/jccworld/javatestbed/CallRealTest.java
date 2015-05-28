package com.jccworld.javatestbed;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * User: jcc
 * Date: 24/05/15
 */
public class CallRealTest {

    private Thing sut;
    @Mock private NumberGeneratorImpl mockNumberGenerator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sut = new Thing(mockNumberGenerator);
    }

    @Test
    public void reportsTheCorrectName() {
        // init
        final String expected = "X123";
        when(mockNumberGenerator.getNumber()).thenCallRealMethod();

        // run
        String result = sut.generateCustomId();

        // verify
        assertEquals(expected, result);
    }

    private class NumberGeneratorImpl implements NumberGenerator {

        @Override
        public int getNumber() {
            return 123;
        }
    }
}
