package com.hus23.assignment.socialmediaplatform.controller;

import com.hus23.assignment.socialmediaplatform.data.User;
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
    public ResponseEntity getGuests(@RequestBody User user){

        // model.addAttribute("guests", this.reservationService.getHotelGuests());
        // return "hotel-guests";
        this.userService.addUser(user);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/DelUser/{userId}")
    public  ResponseEntity deleteCourse(@PathVariable String userId)
    {
         this.userService.deleteUser(Long.parseLong(userId));
         return ResponseEntity.ok().build();
    }
    @GetMapping("/user")
    public ResponseEntity<?>getallUsers(Model model){
        //model.addAttribute("guests", this.reservationService.getHotelGuests());
        // return "hotel-guests";
        System.out.println("calling User controller");
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }
    @GetMapping("/LoggedInUserDetails/{userID}")
    public ResponseEntity<?>LoggedInUserDetails(@PathVariable String userID)
    {

        //model.addAttribute("guests", this.reservationService.getHotelGuests());
        // return "hotel-guests";
        System.out.println("calling User controller");
        return new ResponseEntity<>(this.userService.loginuserdetails(Long.parseLong(userID)), HttpStatus.OK);
    }

}
