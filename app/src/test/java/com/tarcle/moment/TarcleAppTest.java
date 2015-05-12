package com.tarcle.moment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(TarcleRobolectricTestRunner.class)
public class TarcleAppTest {

    private TarcleApp app;

    @Before
    public void setUp() {
        app = TarcleApp.getInstance();
    }

    @Test
    public void shouldGetInstance() {
        assertThat(app).isNotNull();
    }

}