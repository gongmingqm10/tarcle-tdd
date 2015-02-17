package com.tarcle.moment.activity;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest="./src/main/AndroidManifest.xml", emulateSdk = 18)
public class RootActivityTest extends TestCase {

    @Test
    public void dummyTest() {
        assertThat(1+1).isEqualTo(2);
    }

}