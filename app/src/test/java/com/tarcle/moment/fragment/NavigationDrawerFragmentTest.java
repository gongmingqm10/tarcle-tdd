package com.tarcle.moment.fragment;

import android.widget.ListView;

import com.tarcle.moment.TarcleRobolectricTestRunner;
import com.tarcle.moment.activity.RootActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowListView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.robolectric.Shadows.shadowOf;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(TarcleRobolectricTestRunner.class)
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

    @Test
    public void shouldInvokeCallbackWhenItemIsClicked() {
        RootActivity spyActivity = spy(Robolectric.buildActivity(RootActivity.class).create().start().resume().get());
        fragment.onAttach(spyActivity);

        int position = 2;
        ShadowListView shadowListView = shadowOf(fragment.mDrawerListView);
        shadowListView.performItemClick(position);
        verify(spyActivity).onNavigationDrawerItemSelected(eq(position));
    }
}