package com.tarcle.moment.event;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RestEvent<T> implements Callback<T> {
    @Override
    public void success(T t, Response response) {
        BusProvider.getInstance().post(t);
    }

    @Override
    public void failure(RetrofitError error) {
        BusProvider.getInstance().post(error);
    }
}
