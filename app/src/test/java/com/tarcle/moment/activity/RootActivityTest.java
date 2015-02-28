package com.tarcle.moment.activity;

import com.tarcle.moment.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class RootActivityTest {

    private RootActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(RootActivity.class).create().start().resume().get();
    }

    @Test
    public void shouldCreateRootActivity() {
        assertThat(activity).isNotNull();
    }

    @Test
    public void shouldUpdtaeTitleWhenCircleFragmentShows() {
        activity.onNavigationDrawerItemSelected(0);
        assertThat(activity.getTitle()).isEqualTo(activity.getString(R.string.circle));
    }

    @Test
    public void shouldUpdateTitleWhenTopicFragmentShows() {
        activity.onNavigationDrawerItemSelected(1);
        assertThat(activity.getTitle()).isEqualTo(activity.getString(R.string.topic));
    }

    @Test
    public void shouldUpdateTitleWhenMineFragmentShows() {
        activity.onNavigationDrawerItemSelected(2);
        assertThat(activity.getTitle()).isEqualTo(activity.getString(R.string.mine));
    }

}