package com.tarcle.moment.fragment;

import android.widget.ListAdapter;

import com.squareup.otto.Bus;
import com.tarcle.moment.activity.RootActivity;
import com.tarcle.moment.event.BusProviderInjection;
import com.tarcle.moment.model.Circle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowListView;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.robolectric.Robolectric.shadowOf;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class CircleFragmentTest {

    private CircleFragment circleFragment;
    private Bus mockedBus;

    @Before
    public void setUp() {
        circleFragment = new CircleFragment();
        mockedBus = mock(Bus.class);
        BusProviderInjection.setBus(mockedBus);

        startFragment(circleFragment, RootActivity.class);

        ArrayList<Circle> circles = newArrayList(
                new Circle().setName("Circle Song").setDescription("The circle Song description").build(),
                new Circle().setName("Circle Tang").setDescription("The circle Tang description").build()
                );
        
        circleFragment.showCircles(circles);
    }

    @After
    public void tearDown() {
        circleFragment.onPause();
    }

    @Test
    public void shouldRegisterOrUnregisterBusOnFragmentLifeCycle() {
        verify(mockedBus).register(eq(circleFragment));

        circleFragment.onPause();
        verify(mockedBus).unregister(eq(circleFragment));
    }

    @Test
    public void shouldShowCirclesInListView() {
        ListAdapter adapter = circleFragment.getListAdapter();

        assertThat(adapter.getCount()).isEqualTo(2);

        Circle circle = (Circle) adapter.getItem(0);
        assertThat(circle.getName()).isEqualTo("Circle Song");
    }

    @Test
    public void shouldShowCircleNameInListItem() {
        ShadowListView shadowListView = shadowOf(circleFragment.getListView());

        int position = shadowListView.findIndexOfItemContainingText("Circle Tang");
        assertThat(position).isEqualTo(1);
    }
}