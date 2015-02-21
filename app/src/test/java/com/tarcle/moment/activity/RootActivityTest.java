package com.tarcle.moment.activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class RootActivityTest {

    @Test
    public void shouldCreateRootActivity() {
        RootActivity activity = Robolectric.buildActivity(RootActivity.class).create().get();
        assertThat(activity).isNotNull();
    }
}