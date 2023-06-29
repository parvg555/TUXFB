package com.hus23.assignment.socialmediaplatform.services;

import com.hus23.assignment.socialmediaplatform.data.*;
import com.hus23.assignment.socialmediaplatform.pojo.PasswordChangeVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public void updateUser(User updatedUser, Integer userId){
        userRepository.updateUser(
                    updatedUser.getUsername(),
                    updatedUser.getFirstName(),
                    updatedUser.getLastName(),
                    updatedUser.getEmailAddress(),
                    userId
        );
    }

    public String updatePassword(PasswordChangeVO passwordChangeVO, Integer userId){
        try{
            if(!Objects.equals(passwordChangeVO.getConfirmPassword(), passwordChangeVO.getPassword())){
                return "password and confirm password does not match!";
            }
            try {
                User user = userRepository.getById((long) userId);
                if(!Objects.equals(user.getPass(), passwordChangeVO.getOldPassword())){
                    return "old password incorrect!";
                }
            }catch(Exception e){
                return "invalid user id";
            }
            userRepository.updatePassword(passwordChangeVO.getPassword(), userId);
        }catch(Exception e){
            return "Internal Server Error!";
        }
        return "Password Updated!";
    }

    public void deleteUser(Integer userId){
        userRepository.deleteById((long) userId);
    }

}
