package com.hus23.assignment.socialmediaplatform.pojo;

import com.hus23.assignment.socialmediaplatform.data.User;

import java.util.ArrayList;
import java.util.List;

public class FollowersFollowingVO {

    List<User> followers;

    List<User> following;

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = new ArrayList<>();
        for(User follower: followers){
            User newUser = new User();
            newUser.setId(follower.getId());
            newUser.setUsername(follower.getUsername());
            newUser.setFirstName(follower.getFirstName());
            newUser.setLastName(follower.getLastName());
            newUser.setEmailAddress(follower.getEmailAddress());
            newUser.setCreatedat(follower.getCreatedat());
            this.followers.add(newUser);
        }
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = new ArrayList<>();
        for(User follower: following){
            User newUser = new User();
            newUser.setId(follower.getId());
            newUser.setUsername(follower.getUsername());
            newUser.setFirstName(follower.getFirstName());
            newUser.setLastName(follower.getLastName());
            newUser.setEmailAddress(follower.getEmailAddress());
            newUser.setCreatedat(follower.getCreatedat());
            this.following.add(newUser);
        }
    }
}
