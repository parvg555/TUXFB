package com.hus23.assignment.socialmediaplatform.controller;

import com.hus23.assignment.socialmediaplatform.data.Posts;
import com.hus23.assignment.socialmediaplatform.data.User;
import com.hus23.assignment.socialmediaplatform.pojo.CommentVO;
import com.hus23.assignment.socialmediaplatform.pojo.PostVO;
import com.hus23.assignment.socialmediaplatform.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/getPostsByLocation")
    public ResponseEntity<?> getPostsByLocation(@RequestBody String location){
        try{
            List<Posts> searchResults= postService.getPostsByLocation(location);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createPost/{userId}")
    public ResponseEntity<?> createPost(@RequestBody PostVO postVO, @PathVariable("userId") Integer userId){
        try{
            postService.createPost(postVO,userId);
            return new ResponseEntity<>("New Post Created!", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updatePost/{postId}")
    public ResponseEntity<?> updatePost(@RequestBody PostVO postVO, @PathVariable("postId") Integer postId){
        try{
            postService.updatePost(postVO,postId);
            return new ResponseEntity<>("Post updated!", HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Invalid PostId!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("postId") Integer postId){
        try{
            postService.deletePost(postId);
            return new ResponseEntity<>("Post Deleted!", HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Invalid PostId!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAllPosts/{userId}")
    public ResponseEntity<?> deleteAllPostsByUserId(@PathVariable("userId") Integer userId){
        try{
            postService.deleteAllPostsByUserId(userId);
            return new ResponseEntity<>("Posts Deleted!", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Invalid PostId!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/comment/{postId}")
    public ResponseEntity<?> comment(@RequestBody CommentVO commentVO,  @PathVariable("postId") Integer postId){
        try{
            postService.comment(commentVO,postId);
            return new ResponseEntity<>("Comment posted!", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Bad Request!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/editComment/{postId}")
    public ResponseEntity<?> editComment(@RequestBody CommentVO commentVO, @PathVariable("postId") Integer postId){
        try{
            String message = postService.editComment(commentVO,postId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Bad Request!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/deleteComment/{commentId}/{userId}")
    public ResponseEntity<?> deleteComment(@PathVariable("commentId") Integer commentId, @PathVariable("userId") Integer userId){
        try{
            String message = postService.deleteComment(commentId,userId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Bad Request!", HttpStatus.BAD_REQUEST);
        }
    }


}
