package com.jccworld.javatestbed;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * User: jcc
 * Date: 24/05/15
 */
public class SpyTest {

    private FSM sut;

    @Mock private NumberGenerator mockNumberGenerator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sut = new FSM(mockNumberGenerator);
    }

    @Test
    public void reportsTheCorrectName() {
        // init
        FSM spySut = spy(sut);

        // run
        spySut.doIt();

        // verify that is calls itself
        verify(spySut).stop();
    }
}
