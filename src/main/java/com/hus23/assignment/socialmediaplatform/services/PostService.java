package com.hus23.assignment.socialmediaplatform.services;

import com.hus23.assignment.socialmediaplatform.data.*;
import com.hus23.assignment.socialmediaplatform.pojo.CommentVO;
import com.hus23.assignment.socialmediaplatform.pojo.PostVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostsRepository postsRepository;

    private final FollowsRepository followsRepository;

    private final CommentsRepository commentsRepository;

    public PostService(PostsRepository postsRepository, FollowsRepository followsRepository, CommentsRepository commentsRepository){
        this.postsRepository = postsRepository;
        this.followsRepository = followsRepository;
        this.commentsRepository = commentsRepository;
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

    public void updatePost(PostVO postVO, Integer postId){
        try {
            postsRepository.updatePostById(postVO.getContent(), postVO.getLocation(), postId);
        }catch(Exception e){
            throw e;
        }
    }

    public void deletePost(Integer postId){
        postsRepository.deleteById((long) postId);
    }

    public void deleteAllPostsByUserId(Integer userId){
        try{
            postsRepository.deleteAllPostsByUserId(userId);
        }catch (Exception e){
            throw e;
        }
    }

    public void comment(CommentVO commentVO, Integer postId){
        try{
            //check follower or following
            Posts post = postsRepository.getById((long) postId);
            if(isFollowerOrFollowing(post.getUser_id(), commentVO.getUser_id())){
                Comments comment = new Comments();
                comment.setPost_id(postId);
                comment.setUser_id(commentVO.getUser_id());
                comment.setContent(commentVO.getContent());
                commentsRepository.save(comment);
            }
        }catch(Exception e){
            throw e;
        }
    }

    public boolean isFollowerOrFollowing(long user1, long user2){
        List<Integer> check1 = followsRepository.isMyFollower(user1,user2);
        if(check1.size() > 0) return true;
        List<Integer> check2 = followsRepository.isMyFollower(user2,user1);
        if(check2.size() > 0) return true;
        return false;
    }

}
