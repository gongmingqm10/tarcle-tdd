package com.tarcle.moment.fragment;

import android.widget.ListAdapter;

import com.squareup.otto.Bus;
import com.tarcle.moment.TarcleRobolectricTestRunner;
import com.tarcle.moment.activity.RootActivity;
import com.tarcle.moment.event.BusProviderInjection;
import com.tarcle.moment.model.Role;
import com.tarcle.moment.model.Topic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.shadows.ShadowListView;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.robolectric.Robolectric.shadowOf;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(TarcleRobolectricTestRunner.class)
public class TopicFragmentTest {

    private TopicFragment topicFragment;
    private Bus mockedBus;

    @Before
    public void setUp() {
        topicFragment = new TopicFragment();
        mockedBus = mock(Bus.class);
        BusProviderInjection.setBus(mockedBus);

        startFragment(topicFragment, RootActivity.class);

        ArrayList<Topic> topics = newArrayList(
                new Topic().setContent("Topic 1 content").setTime("Yesterday").setLocation("Wuhan").setAuthor(new Role("1", "Li Bai", "http://img2.ph.126.net/E8xlQGMVw16QZpUHXAirEw==/6597953774007048047.jpg", null)),
                new Topic().setContent("Topic 2 content").setTime("2012-02-09").setLocation("Chang An").setAuthor(new Role("1", "Xi Shi", "http://image.cncn6.com/server12/month_1302/130202114381cf19f6b7bba907.jpg", null))
        );

        topicFragment.showCircles(topics);
    }

    @Test
    public void shouldRegisterOrUnregisterOnFragmentLifecycle() {
        verify(mockedBus).register(eq(topicFragment));
        topicFragment.onPause();
        verify(mockedBus).unregister(eq(topicFragment));
    }

    @Test
    public void shouldInflateDataToAdapter() {
        ListAdapter adapter = topicFragment.getListAdapter();

        assertThat(adapter.getCount()).isEqualTo(2);

        Topic topic = (Topic) adapter.getItem(1);
        assertThat(topic.getContent()).isEqualTo("Topic 2 content");
    }

    @Test
    public void shouldShowContentInListView() {
        ShadowListView shadowListView = shadowOf(topicFragment.getListView());

        int index = shadowListView.findIndexOfItemContainingText("Topic 1 content");
        assertThat(index).isEqualTo(0);
    }

}