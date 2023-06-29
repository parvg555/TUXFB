package com.hus23.assignment.socialmediaplatform.controller;

import com.hus23.assignment.socialmediaplatform.data.Posts;
import com.hus23.assignment.socialmediaplatform.data.User;
import com.hus23.assignment.socialmediaplatform.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
