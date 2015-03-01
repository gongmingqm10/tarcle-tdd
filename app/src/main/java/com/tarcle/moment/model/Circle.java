package com.tarcle.moment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Circle {
    
    @SerializedName("id")
    private String id;
    
    @SerializedName("name")
    private String name;
    
    @SerializedName("description")
    private String description;
    
    @SerializedName("images")
    private String[] images;
    
    @SerializedName("time")
    private String createdTime;
    
    @SerializedName("roles")
    private List<Role> roles;
    
    @SerializedName("followers")
    private List<User> followers;
    
    @SerializedName("topics")
    private List<Topic> topics;
    
    @SerializedName("rolesCount")
    private int rolesCount;
    
    @SerializedName("followersCount")
    private int followersCount;
    
    @SerializedName("topicsCount")
    private int topicsCount;

    public Circle(String id, String name, String description, String[] images, String createdTime, 
                  List<Role> roles, List<User> followers, List<Topic> topics, 
                  int rolesCount, int followersCount, int topicsCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.createdTime = createdTime;
        this.roles = roles;
        this.followers = followers;
        this.topics = topics;
        this.rolesCount = rolesCount;
        this.followersCount = followersCount;
        this.topicsCount = topicsCount;
    }

    public Circle() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getImages() {
        return images;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public int getRolesCount() {
        return rolesCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getTopicsCount() {
        return topicsCount;
    }
    
    public String getAvatar() {
        return images == null || images.length == 0 ? null : images[0];
        
    }

    public Circle setName(String name) {
        this.name = name;
        return this;
    }

    public Circle setDescription(String description) {
        this.description = description;
        return this;
    }
    
    public Circle build() {
        return this;
    }
}
