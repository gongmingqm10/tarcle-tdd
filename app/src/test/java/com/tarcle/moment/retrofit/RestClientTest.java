package com.tarcle.moment.retrofit;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RestClientTest {

    private RestClient restClient;

    @Before
    public void setUp() {
        restClient = restClient.getInstance();
    }
    
    @Test
    public void shouldGetInstance() {
        assertThat(restClient).isNotNull();
    }
    
    @Test
    public void shouldGetTopicService() {
        assertThat(restClient.getTopicService()).isNotNull();
    }
    
    @Test
    public void shouldGetCircleService() {
        assertThat(restClient.getCircleService()).isNotNull();
    }
}