package com.tarcle.moment.event;

public class ApiCallbackEvent<T> {
    private final T data;
    private final String tag;

    public ApiCallbackEvent(T data, String tag) {

        this.data = data;
        this.tag = tag;
    }

    public T getData() {
        return data;
    }

    public String getTag() {
        return tag;
    }
}
