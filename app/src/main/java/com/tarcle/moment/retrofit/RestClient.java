package com.tarcle.moment.retrofit;

import com.tarcle.moment.retrofit.service.CircleService;
import com.tarcle.moment.retrofit.service.TopicService;

import retrofit.RestAdapter;

public class RestClient {

    private static String BASE_URL = "http://54.200.7.85:9090";

    private static RestClient instance;

    private RestAdapter restAdapter;
    
    public static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }
    
    private RestClient() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();
    }

    public CircleService getCircleService() {
        return restAdapter.create(CircleService.class);
    }
    
    public TopicService getTopicService() {
        return restAdapter.create(TopicService.class);
    }

}
