package com.tarcle.moment.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;
import com.tarcle.moment.R;
import com.tarcle.moment.event.BusProvider;
import com.tarcle.moment.event.RestEvent;
import com.tarcle.moment.model.Topic;
import com.tarcle.moment.retrofit.RestClient;

import java.util.ArrayList;
import java.util.List;

public class TopicFragment extends ListFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic, container, false);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        getActivity().setTitle(R.string.topic);
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
        RestClient.getInstance().getTopicService().index(new RestEvent<List<Topic>>());
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Subscribe
    public void showCircles(ArrayList<Topic> topics) {

    }
}
