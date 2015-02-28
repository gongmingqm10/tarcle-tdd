package com.tarcle.moment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.squareup.otto.Subscribe;
import com.tarcle.moment.R;
import com.tarcle.moment.model.Circle;
import com.tarcle.moment.event.BusProvider;
import com.tarcle.moment.event.RestEvent;
import com.tarcle.moment.retrofit.RestClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CircleFragment extends Fragment {
    
    @InjectView(android.R.id.list)
    protected ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle, container, false);
        ButterKnife.inject(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RestClient.getInstance().getCircleService().index(new RestEvent<List<Circle>>());
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        getActivity().setTitle(R.string.circle);
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }
    
    @Subscribe
    public void getCircles(ArrayList<Circle> circles) {
        //TODO show circles in the ListView
    }
}
