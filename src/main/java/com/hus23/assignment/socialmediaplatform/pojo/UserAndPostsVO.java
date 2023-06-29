package com.hus23.assignment.socialmediaplatform.pojo;

import com.hus23.assignment.socialmediaplatform.data.Posts;
import com.hus23.assignment.socialmediaplatform.data.User;

import java.util.List;

public class UserAndPostsVO {
    private User user;
    private List<Posts> posts;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }
}
