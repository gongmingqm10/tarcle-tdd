package com.tarcle.moment.fragment;

import android.widget.ListView;

import com.tarcle.moment.activity.RootActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class NavigationDrawerFragmentTest {

    private NavigationDrawerFragment fragment;

    @Before
    public void setUp() {
        fragment = new NavigationDrawerFragment();
        startFragment(fragment, RootActivity.class);
    }

    @Test
    public void shouldCreateListView() {
        ListView listView = fragment.mDrawerListView;
        assertThat(listView).isNotNull();
    }

    @Test
    public void shouldContainsThreeItems() {
        ListView listView = fragment.mDrawerListView;
        assertThat(listView.getAdapter().getCount()).isEqualTo(3);
    }

}