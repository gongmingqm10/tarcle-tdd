package com.tarcle.moment;

import com.tarcle.moment.retrofit.RestClient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
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