package com.jccworld.javatestbed;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class CaptorTest {

    private EncapsulatedLogic sut;

    @Mock private Delegate mockDelegate;
    @Captor private ArgumentCaptor<Private> captor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sut = new EncapsulatedLogic(mockDelegate);
    }

    @Test
    public void capturesIncapsulatedLogic() {
        // init
        final String expected = "hidden value";

        // run
        sut.delegatePrivate();

        // post-run init
        verify(mockDelegate).handle(captor.capture());
        final Private value = captor.getValue();

        // verify
        assertEquals(expected, value.getKey());
    }
}