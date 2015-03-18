package com.tarcle.moment.retrofit;

import com.tarcle.moment.event.BusProvider;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class BaseCallBack<T> implements Callback<T> {
    @Override
    public void success(T t, Response response) {
        BusProvider.getInstance().post(t);
    }

    @Override
    public void failure(RetrofitError error) {
        BusProvider.getInstance().post(error);
    }
}
