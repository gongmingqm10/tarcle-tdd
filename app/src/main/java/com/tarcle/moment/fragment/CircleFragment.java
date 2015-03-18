package com.tarcle.moment.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;
import com.tarcle.moment.R;
import com.tarcle.moment.event.BusProvider;
import com.tarcle.moment.retrofit.BaseCallBack;
import com.tarcle.moment.model.Circle;
import com.tarcle.moment.retrofit.RestClient;
import com.tarcle.moment.view.CircleListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit.RetrofitError;

public class CircleFragment extends ListFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle, container, false);
        ButterKnife.inject(this, view);
        return view;
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
        RestClient.getInstance().getCircleService().index(new BaseCallBack<List<Circle>>());
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Subscribe
    public void showCircles(ArrayList<Circle> circles) {
        CircleListAdapter adapter = new CircleListAdapter(
                getActivity().getApplicationContext(),
                R.layout.circle_list_item,
                circles);
        setListAdapter(adapter);
    }

    @Subscribe
    public void error(RetrofitError error) {
        Log.e("gongmingqm10", error.getUrl() + " " + error.getLocalizedMessage());

    }
}
