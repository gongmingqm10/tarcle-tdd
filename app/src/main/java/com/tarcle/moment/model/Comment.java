package com.tarcle.moment.model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    
    @SerializedName("id")
    private String id;
    
    @SerializedName("content")
    private String content;
    
    @SerializedName("time")
    private String time;
    
    @SerializedName("author")
    private Role author;
    
    @SerializedName("reply")
    private Role reply;

    public Comment(String id, String content, String time, Role author, Role reply) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.author = author;
        this.reply = reply;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public Role getAuthor() {
        return author;
    }

    public Role getReply() {
        return reply;
    }
}
