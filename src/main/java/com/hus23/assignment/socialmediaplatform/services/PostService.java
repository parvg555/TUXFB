package com.hus23.assignment.socialmediaplatform.services;

import com.hus23.assignment.socialmediaplatform.data.Posts;
import com.hus23.assignment.socialmediaplatform.data.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostsRepository postsRepository;

    public PostService(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }

    public List<Posts> getPostsByLocation(String location){
        return postsRepository.getPostsByLocation(location);
    }

}
