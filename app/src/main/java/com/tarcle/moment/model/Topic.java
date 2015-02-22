package com.tarcle.moment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Topic {
    
    @SerializedName("id")
    private String id;
    
    @SerializedName("content")
    private String content;
    
    @SerializedName("images")
    private String[] images;

    @SerializedName("address")
    private String location;

    @SerializedName("time")
    private String time;

    @SerializedName("author")
    private Role author;

    @SerializedName("like")
    private List<Role> followers;
    
    @SerializedName("comments")
    private List<Comment> comments;

    public Topic(String id, String content, String[] images, String location, String time, Role author, 
                 List<Role> followers, List<Comment> comments) {
        this.id = id;
        this.content = content;
        this.images = images;
        this.location = location;
        this.time = time;
        this.author = author;
        this.followers = followers;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String[] getImages() {
        return images;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public Role getAuthor() {
        return author;
    }

    public List<Role> getFollowers() {
        return followers;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
