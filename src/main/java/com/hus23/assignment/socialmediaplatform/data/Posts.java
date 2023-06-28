package com.hus23.assignment.socialmediaplatform.data;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="posts")
public class Posts {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_id")
    private long user_id;
    @Column(name = "content")
    private String content;
    @Column(name = "location")
    private String location;

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    @Column(name = "created_at")
    private String createdat;

    public Posts() {
    }

    public Posts(long id, long user_id, String content, String location, String createdat) {
        this.id = id;
        this.user_id = user_id;
        this.content = content;
        this.location = location;
        this.createdat = createdat;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

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

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", location='" + location + '\'' +
                ", createdat='" + createdat + '\'' +
                '}';
    }
}
