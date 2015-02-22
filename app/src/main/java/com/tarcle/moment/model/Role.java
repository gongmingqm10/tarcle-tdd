package com.tarcle.moment.model;

import com.google.gson.annotations.SerializedName;

public class Role {
    
    @SerializedName("id")
    private String id;
    
    @SerializedName("name")
    private String name;
    
    @SerializedName("avatar")
    private String avatar;
    
    @SerializedName("user")
    private User user;

    public Role(String id, String name, String avatar, User user) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public User getUser() {
        return user;
    }
}
