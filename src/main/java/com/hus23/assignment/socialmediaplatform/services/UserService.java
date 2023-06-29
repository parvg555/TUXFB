package com.hus23.assignment.socialmediaplatform.services;

import com.hus23.assignment.socialmediaplatform.data.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User guest) {
        User guest1 = new User();
        guest1.setUsername(guest.getUsername());
        guest1.setFirstName(guest.getFirstName());
        guest1.setLastName(guest.getLastName());
        guest1.setEmailAddress(guest.getEmailAddress());
        guest1.setPass(guest.getPass());
        LocalDateTime now = LocalDateTime.now();
        guest1.setCreatedat(now);
        userRepository.save(guest1);
        return guest1;
    }
}
