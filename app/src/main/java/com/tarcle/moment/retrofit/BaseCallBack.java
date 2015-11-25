package com.tarcle.moment.retrofit;

import com.tarcle.moment.event.ApiCallbackEvent;
import com.tarcle.moment.event.BusProvider;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class BaseCallBack<T> implements Callback<T> {

    private final String tag;

    public BaseCallBack(String tag) {
        this.tag = tag;
    }

    @Override
    public void success(T t, Response response) {
        BusProvider.getInstance().post(new ApiCallbackEvent<>(t, tag));
    }

    @Override
    public void failure(RetrofitError error) {
        BusProvider.getInstance().post(error);
    }
}
