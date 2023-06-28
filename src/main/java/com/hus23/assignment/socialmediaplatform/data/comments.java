package com.hus23.assignment.socialmediaplatform.data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="comments")
public class comments {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_id")
    private long user_id;
    @Column(name = "post_id")
    private long post_id;
    @Column(name = "content")
    private String content;

    public comments(long id, long user_id, long post_id, String content) {
        this.id = id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.content = content;
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

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "comments{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", post_id=" + post_id +
                ", content='" + content + '\'' +
                '}';
    }
}
