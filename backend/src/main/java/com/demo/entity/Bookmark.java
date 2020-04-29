package com.demo.entity;

import org.springframework.data.annotation.Id;

public class Bookmark {

    @Id
    private String id;
    private String username;
    private String name;
    private String url;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
}
