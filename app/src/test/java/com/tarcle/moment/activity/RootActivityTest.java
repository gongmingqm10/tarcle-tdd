package com.tarcle.moment.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.tarcle.moment.R;
import com.tarcle.moment.fragment.CircleFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.util.ActivityController;

import butterknife.ButterKnife;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.robolectric.Robolectric.shadowOf;

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
    public void shouldUpdateTitleWhenMineFragmentShows(){
        activity.onNavigationDrawerItemSelected(2);
        assertThat(activity.getTitle()).isEqualTo(activity.getString(R.string.mine));
    }
    
}