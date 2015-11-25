package com.tarcle.moment.retrofit.service;

import com.tarcle.moment.model.Circle;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface CircleService {
    @GET("/circles.json")
    void index(Callback<List<Circle>> callback);

    @GET("/circles/{id}")
    void get(@Path("id") String circleId, Callback<Circle> callback);
}
