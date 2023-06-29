package com.hus23.assignment.socialmediaplatform.services;

import com.hus23.assignment.socialmediaplatform.data.Posts;
import com.hus23.assignment.socialmediaplatform.data.PostsRepository;
import com.hus23.assignment.socialmediaplatform.pojo.PostVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public void createPost(PostVO postVO, Integer userId){
        Posts newPost = new Posts();
        newPost.setContent(postVO.getContent());
        newPost.setLocation(postVO.getLocation());
        newPost.setUser_id(userId);
        LocalDateTime now = LocalDateTime.now();
        newPost.setCreatedat(now);
        postsRepository.save(newPost);
    }


}
