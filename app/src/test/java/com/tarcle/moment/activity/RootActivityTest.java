package com.tarcle.moment.activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class RootActivityTest {

    private ActivityController<RootActivity> controller;

    @Before
    public void setUp() {
        controller = Robolectric.buildActivity(RootActivity.class).create();
    }

    @Test
    public void shouldCreateRootActivity() {
        assertThat(controller.get()).isNotNull();
    }
    
    @Test
    public void shouldShowCircleFragment() {
        
    }
    
    @Test
    public void shouldShowTopicFragment() {
        
        
    }
    
    @Test
    public void shouldShowMineFragment(){
        
        
    }
    
}