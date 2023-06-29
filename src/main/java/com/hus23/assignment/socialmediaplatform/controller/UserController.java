package com.hus23.assignment.socialmediaplatform.controller;

import com.hus23.assignment.socialmediaplatform.data.User;
import com.hus23.assignment.socialmediaplatform.pojo.PasswordChangeVO;
import com.hus23.assignment.socialmediaplatform.pojo.UserAndPostsVO;
import com.hus23.assignment.socialmediaplatform.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        User createdUser = null;
        try {
            createdUser = this.userService.addUser(user);
        }catch(Exception e){
            return new ResponseEntity<>("username or email already exists", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/updateUser/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("userId") Integer userId){
        try{
            userService.updateUser(user,userId);
        }catch(Exception e){
            return new ResponseEntity<>("username or email already exists", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("user updated!", HttpStatus.CREATED);
    }

    @PutMapping("/updatePassword/{userId}")
    public ResponseEntity<?> updatePassword(@RequestBody PasswordChangeVO passwordChangeVO, @PathVariable("userId") Integer userId){
        String message = "";
        try{
            message = userService.updatePassword(passwordChangeVO,userId);
        }catch(Exception e){
            return new ResponseEntity<>("Bad request!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted!", HttpStatus.OK);
    }

    @GetMapping("/getDetails/{userId}")
    public ResponseEntity<?> getDetails(@PathVariable("userId") Integer userId){
        UserAndPostsVO details = null;
        try{
            details = userService.getDetails(userId);
        }catch(Exception e){
            return new ResponseEntity<>("Bad request!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsers(@RequestBody String query){
        try{
            List<User> searchResults= userService.getUsers(query);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Bad request!", HttpStatus.BAD_REQUEST);
        }
    }

}
