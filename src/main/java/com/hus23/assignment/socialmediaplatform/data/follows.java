package com.hus23.assignment.socialmediaplatform.data;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="follows")
public class follows {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "following_id")
    private long following_id;
    @Column(name = "follower_id")
    private String follower_id;

    public follows(long id, long following_id, String follower_id) {
        this.id = id;
        this.following_id = following_id;
        this.follower_id = follower_id;
    }

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

    public String getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(String follower_id) {
        this.follower_id = follower_id;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", following_id=" + following_id +
                ", follower_id='" + follower_id + '\'' +
                '}';
    }
}
