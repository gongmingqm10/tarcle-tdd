package com.tarcle.moment.activity;

import com.tarcle.moment.R;
import com.tarcle.moment.TarcleRobolectricTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(TarcleRobolectricTestRunner.class)
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
    public void shouldUpdateTitleWhenCircleFragmentShows() {
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