package com.hus23.assignment.socialmediaplatform.pojo;

import jakarta.persistence.Column;

public class PostVO {
    private String content;
    private String location;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
