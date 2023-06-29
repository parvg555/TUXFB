package com.hus23.assignment.socialmediaplatform.data;

import jakarta.persistence.*;

@Entity
@Table(name="follows")
public class Follows {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "following_id")
    private long following_id;
    @Column(name = "follower_id")
    private long follower_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFollowing_id() {
        return following_id;
    }

    public void setFollowing_id(long following_id) {
        this.following_id = following_id;
    }

    public long getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(long follower_id) {
        this.follower_id = follower_id;
    }
}
