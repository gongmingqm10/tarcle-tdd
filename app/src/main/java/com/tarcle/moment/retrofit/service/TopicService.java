package com.tarcle.moment.retrofit.service;

import com.tarcle.moment.model.Topic;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface TopicService {
    @GET("/topics.json")
    void index(Callback<List<Topic>> callback);

    @GET("/topics/{id}")
    void get(@Path("id") String topicId, Callback<Topic> callback);
}
